package jlinq;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.functions.Function2;
import jlinq.interfaces.IJLinqWrapper;
import jlinq.interfaces.IParallelJLinqWrapper;
import jlinq.parallel.IParallelQueryOptions;

/**
 * 
 * Executes JLinq methods on specified collection in parallel.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class ParallelJLinqWrapper<TSource> implements IParallelJLinqWrapper<TSource> {

	/**
	 * Options used by parallel operations.
	 */
	private IParallelQueryOptions queryOptions;
	/**
	 * Contains list of all collections from different threads.
	 */
	private List<IJLinqWrapper<TSource>> collectionPerThread;

	public ParallelJLinqWrapper(IJLinqWrapper<TSource> source, IParallelQueryOptions queryOperations)
			throws IllegalAccessException {
		this.queryOptions = queryOperations;
		this.collectionPerThread = new ArrayList<IJLinqWrapper<TSource>>();

		this.divideSource(source);
	}

	public ParallelJLinqWrapper(List<IJLinqWrapper<TSource>> innerParallelCollection,
			IParallelQueryOptions queryOptions) {
		this.collectionPerThread = innerParallelCollection;
		this.queryOptions = queryOptions;
	}

	public TSource aggregate(Function2<TSource, TSource, TSource> func)
			throws InterruptedException, ExecutionException, IllegalAccessException {
		return this.executeParallelMethod(col -> col.aggregate(func)).asIterable().aggregate(func);
	}

	/**
	 * @return Returns true when all values from parallel collections return true;
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public boolean all(Predicate<TSource> predicate)
			throws InterruptedException, ExecutionException, IllegalAccessException {
		return this.executeParallelMethod(col -> col.all(predicate)).asIterable()
				.all(val -> val.booleanValue() == true);
	}

	public boolean any(Predicate<TSource> predicate)
			throws InterruptedException, ExecutionException, IllegalAccessException {
		return this.executeParallelMethod(col -> col.any(predicate)).asIterable()
				.any(val -> val.booleanValue() == true);
	}

	public IJLinqWrapper<TSource> asIterable() throws IllegalAccessException {
		List<TSource> list = new ArrayList<TSource>();
		this.collectionPerThread.forEach(col -> list.addAll(col.toList()));
		return new JLinqWrapper<TSource>(list);
	}

	public <TResult> IParallelJLinqWrapper<TResult> cast(Function<TSource, TResult> func)
			throws InterruptedException, ExecutionException, IllegalAccessException {
		return (IParallelJLinqWrapper<TResult>) this.executeParallelMethod(col -> col.cast(func));
	}

	public boolean contains(TSource value) throws IllegalAccessException, InterruptedException, ExecutionException {
		return this.executeParallelMethod(col -> col.contains(value)).asIterable()
				.any(val -> val.booleanValue() == true);
	}

	public boolean contains(TSource value, Comparator<TSource> comparator)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		return this.executeParallelMethod(col -> col.contains(value, comparator)).asIterable()
				.any(val -> val.booleanValue() == true);
	}

	public int count() throws IllegalAccessException, InterruptedException, ExecutionException {
		return this.executeParallelMethod(col -> col.count()).asIterable().asNumbered(val -> val).sum();
	}

	public int count(Predicate<TSource> predicate)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		return this.executeParallelMethod(col -> col.count(predicate)).asIterable().asNumbered(val -> val).sum();
	}

	public IParallelJLinqWrapper<TSource> except(Iterable<TSource> second)
			throws InterruptedException, ExecutionException, IllegalAccessException {
		return (IParallelJLinqWrapper<TSource>) this.executeParallelMethod(col -> col.except(second));
	}

	public void forAll(Consumer<TSource> action)
			throws InterruptedException, ExecutionException, IllegalAccessException {
		this.executeParallelMethod(col -> {
			col.forEach(action);
			return col;
		});
	}

	public long longCount() throws IllegalAccessException, InterruptedException, ExecutionException {
		return this.executeParallelMethod(col -> col.longCount()).asIterable().asNumbered(val -> val).sum();
	}

	public long longCount(Predicate<TSource> predicate)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		return this.executeParallelMethod(col -> col.longCount(predicate)).asIterable().asNumbered(val -> val).sum();
	}

	public <TResult> IParallelJLinqWrapper<TResult> select(Function<TSource, TResult> selector)
			throws InterruptedException, ExecutionException, IllegalAccessException {
		return (IParallelJLinqWrapper<TResult>) this.executeParallelMethod(col -> col.select(selector));
	}

	public <TResult> IParallelJLinqWrapper<TResult> selectMany(Function<TSource, Iterable<TResult>> selector)
			throws InterruptedException, ExecutionException, IllegalAccessException {
		return (IParallelJLinqWrapper<TResult>) this.executeParallelMethod(col -> col.selectMany(selector));
	}

	public boolean sequenceEqual(Iterable<TSource> second)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		return this.executeParallelMethod(col -> col.sequenceEqual(second)).asIterable()
				.all(val -> val.booleanValue() == true);
	}

	public TSource[] toArray() throws IllegalAccessException, InterruptedException, ExecutionException {
		return (TSource[]) this.parseToCollection(new ArrayList<TSource>()).toArray();
	}

	public List<TSource> toList() throws IllegalAccessException, InterruptedException, ExecutionException {
		return this.parseToCollection(new ArrayList<TSource>());
	}

	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		Map<TKey, TElement> map = new HashMap<TKey, TElement>();
		this.executeParallelMethod(col -> {
			Map<TKey, TElement> innerMap = null;

			try {
				innerMap = col.toMap(keySelector, elementSelector);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			map.putAll(innerMap);
			return innerMap;
		});
		return map;
	}

	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector, Comparator<TKey> comparator)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		Map<TKey, TElement> map = new HashMap<TKey, TElement>();
		this.executeParallelMethod(col -> {
			Map<TKey, TElement> innerMap = null;

			try {
				innerMap = col.toMap(keySelector, elementSelector, comparator);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			map.putAll(innerMap);
			return innerMap;
		});
		return map;
	}

	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		Map<TKey, TSource> map = new HashMap<TKey, TSource>();
		this.executeParallelMethod(col -> {
			Map<TKey, TSource> innerMap = null;

			try {
				innerMap = col.toMap(keySelector);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			map.putAll(innerMap);
			return innerMap;
		});
		return map;
	}

	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector, Comparator<TKey> comparator)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		Map<TKey, TSource> map = new HashMap<TKey, TSource>();
		this.executeParallelMethod(col -> {
			Map<TKey, TSource> innerMap = null;

			try {
				innerMap = col.toMap(keySelector, comparator);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

			map.putAll(innerMap);
			return innerMap;
		});
		return map;
	}

	public Set<TSource> toSet() throws IllegalAccessException, InterruptedException, ExecutionException {
		return this.parseToCollection(new HashSet<TSource>());
	}

	public IParallelJLinqWrapper<TSource> where(Predicate<TSource> predicate)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		return (IParallelJLinqWrapper<TSource>) this.executeParallelMethod(col -> {
			try {
				return col.where(predicate);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
		});
	}

	public <TSecond, TResult> IParallelJLinqWrapper<TResult> zip(Iterable<TSecond> second,
			Function2<TSource, TSecond, TResult> resultSelector)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		return (IParallelJLinqWrapper<TResult>) this.executeParallelMethod(col -> {
			try {
				return col.zip(second, resultSelector);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				return null;
			}
		});
	}

	// ---=== Private Mehods ===---

	/**
	 * The purpose of this method is to divide the source collection into
	 * collection-per-thread.
	 * 
	 * @throws IllegalAccessException
	 */
	private void divideSource(IJLinqWrapper<TSource> source) throws IllegalAccessException {
		int sourceCount = source.count();
		int threads = this.queryOptions.getNumberOfThreads();
		int recordsPerThread = sourceCount / threads;

		// +1 for additional data after dividing the integers
		for (int i = 0; i < threads + 1; ++i) {
			List<TSource> sourcePart = source.skip(i * recordsPerThread).take(recordsPerThread).toList();
			this.collectionPerThread.add(new JLinqWrapper<TSource>(sourcePart));
		}
	}

	/**
	 * @param collectionToFill
	 * @return Used to fill specified collection with data from current parallel
	 *         collection.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	private <TCollection extends Collection<TSource>> TCollection parseToCollection(TCollection collectionToFill)
			throws InterruptedException, ExecutionException, IllegalAccessException {
		this.executeParallelMethod(col -> {
			synchronized (collectionToFill) {
				List<TSource> list = col.toList();
				collectionToFill.addAll(list);
				return col;
			}
		});
		return collectionToFill;
	}

	/**
	 * Main method responsible for executing parallel operation on saved
	 * collections.
	 * 
	 * @param func                Main method which will perform execution on saved
	 *                            collection.
	 * @param handleIfNotAWrapper Handler for all methods that will not return a
	 *                            {@link IJLinqWrapper}.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	private <TResult> IParallelJLinqWrapper<TResult> executeParallelMethod(
			Function<IJLinqWrapper<TSource>, TResult> func)
			throws InterruptedException, ExecutionException, IllegalAccessException {

		// Executes specified function in parallel on all threads.
		ExecutorService parallelService = Executors.newFixedThreadPool(this.queryOptions.getNumberOfThreads());
		// Promises of new values.
		List<Future<TResult>> futures = new ArrayList<Future<TResult>>();

		// Prepare parallel operations.
		for (IJLinqWrapper<TSource> sourceCol : this.collectionPerThread) {
			Callable<TResult> run = () -> func.apply(sourceCol);
			Future<TResult> future = parallelService.submit(run);
			futures.add(future);
		}

		// For two possible options.
		List<IJLinqWrapper<TResult>> newCollectionPerThread = new ArrayList<IJLinqWrapper<TResult>>();
		List<TResult> notCollectionResults = new ArrayList<TResult>();

		// Handle parallel results.
		for (Future<TResult> task : futures) {
			TResult result = task.get();

			if (result instanceof IJLinqWrapper<?>) {
				newCollectionPerThread.add((IJLinqWrapper<TResult>) result);
			} else {
				notCollectionResults.add(result);
			}
		}

		// Remove unused threads and clean reserved thread pool.
		parallelService.shutdown();

		// Replace current collection after parallel operations.
		if (newCollectionPerThread.size() > 0) {
			return new ParallelJLinqWrapper<TResult>(newCollectionPerThread, this.queryOptions);
		}
		return new ParallelJLinqWrapper<TResult>(new JLinqWrapper<TResult>(notCollectionResults), this.queryOptions);
	}
}
