package jlinq.interfaces;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.functions.Function2;

/**
 * 
 * Contains methods which will help user to execute parallel operations.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource> Type of the elements inside current collection.
 */
public interface IParallelJLinqWrapper<TSource> {

	/**
	 * @param func
	 * @return Returns aggregated value using specified function.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public TSource aggregate(Function2<TSource, TSource, TSource> func)
			throws InterruptedException, ExecutionException, IllegalAccessException;

	/**
	 * @param predicate
	 * @return Returns true if all values in current collection fulfill the
	 *         specified predicate; otherwise false.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public boolean all(Predicate<TSource> predicate)
			throws InterruptedException, ExecutionException, IllegalAccessException;

	/**
	 * @param predicate
	 * @return Returns true if any element from current collection fulfill the
	 *         specified predicate; otherwise false.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public boolean any(Predicate<TSource> predicate)
			throws InterruptedException, ExecutionException, IllegalAccessException;

	/**
	 * @return Converts current parallel JLinq to {@link IJLinqWrapper}.
	 * @throws IllegalAccessException
	 */
	public IJLinqWrapper<TSource> asIterable() throws IllegalAccessException;

	/**
	 * @param func
	 * @return Casts each element from current collection using specified function.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public <TResult> IParallelJLinqWrapper<TResult> cast(Function<TSource, TResult> func)
			throws InterruptedException, ExecutionException, IllegalAccessException;

	/**
	 * @param value
	 * @return Returns true if the current collection contains the specified value;
	 *         otherwise false.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public boolean contains(TSource value) throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param value
	 * @param comparator
	 * @return Returns true if the current collection contains the specified value
	 *         using specified Comparator; otherwise false.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public boolean contains(TSource value, Comparator<TSource> comparator)
			throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @return Returns the number of elements in current collection. For more items
	 *         than Integer can hold, please see: {@link #longCount()}.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public int count() throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param predicate
	 * @return Returns the number of elements in current collection using specified
	 *         Predicate.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public int count(Predicate<TSource> predicate)
			throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param second
	 * @return Returns the collection which contains the difference of current
	 *         collection and the one specified in the argument.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public IParallelJLinqWrapper<TSource> except(Iterable<TSource> second)
			throws InterruptedException, ExecutionException, IllegalAccessException;

	/**
	 * Executes specified method on all elements in current collection in parallel.
	 * 
	 * @param action
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public void forAll(Consumer<TSource> action)
			throws InterruptedException, ExecutionException, IllegalAccessException;

	/**
	 * @return Returns the number of elements in current collection.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public long longCount() throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param predicate
	 * @return Returns the number of elements in current collection using the
	 *         specified predicate.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public long longCount(Predicate<TSource> predicate)
			throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param selector
	 * @return Returns the elements projected using specified selector.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public <TResult> IParallelJLinqWrapper<TResult> select(Function<TSource, TResult> selector)
			throws InterruptedException, ExecutionException, IllegalAccessException;

	/**
	 * @param selector
	 * @return Returns collection which is build of all projected collections.
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws IllegalAccessException
	 */
	public <TResult> IParallelJLinqWrapper<TResult> selectMany(Function<TSource, Iterable<TResult>> selector)
			throws InterruptedException, ExecutionException, IllegalAccessException;

	/**
	 * @return Converts current collection to an Array.
	 * @throws IllegalAccessException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public TSource[] toArray() throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @return Converts current collection to {@link List}.
	 * @throws IllegalAccessException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public List<TSource> toList() throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param keySelector     Selects key for the {@link Map}.
	 * @param elementSelector Selects element for the {@link Map}.
	 * @return Converts current collection to {@link Map}.
	 * @throws IllegalAccessException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector)
			throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param keySelector     Selects key for the {@link Map}.
	 * @param elementSelector Selects element for the {@link Map}.
	 * @param comparator      Compares elements which will be added to {@link Map}.
	 * @return Converts current collection to {@link Map}.
	 * @throws IllegalAccessException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector, Comparator<TKey> comparator)
			throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param keySelector Selects key for the {@link Map}.
	 * @return Converts current collection to {@link Map}. Where the value of the
	 *         {@link Map} element is the source element.
	 * @throws IllegalAccessException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector)
			throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param keySelector Selects key for the {@link Map}.
	 * @param comparator  Compares elements which will be added to {@link Map}.
	 * @return Converts current collection to {@link Map}. Where the value of the
	 *         {@link Map} element is the source element.
	 * @throws IllegalAccessException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector, Comparator<TKey> comparator)
			throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @return Converts current collection to {@link Set}.
	 * @throws IllegalAccessException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public Set<TSource> toSet() throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param predicate
	 * @return Returns the collection of elements which fulfill the predicate.
	 * @throws IllegalAccessException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public IParallelJLinqWrapper<TSource> where(Predicate<TSource> predicate)
			throws IllegalAccessException, InterruptedException, ExecutionException;

	/**
	 * @param second
	 * @param resultSelector Function that specifies how to connect two elements.
	 * @return Returns the collection of the elements which are connected based on
	 *         the function.
	 * @throws IllegalAccessException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public <TSecond, TResult> IParallelJLinqWrapper<TResult> zip(Iterable<TSecond> second,
			Function2<TSource, TSecond, TResult> resultSelector)
			throws IllegalAccessException, InterruptedException, ExecutionException;
}
