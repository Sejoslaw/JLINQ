package jlinq.interfaces;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.functions.Function2;
import jlinq.parallel.IParallelQueryOptions;

/**
 * 
 * Main interface which contains all methods available in JLinq library. For
 * more information see class jlinq.JLinq;
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource> Type of the elements inside current collection.
 */
public interface IJLinqWrapper<TSource> extends Iterable<TSource> {

	/**
	 * @param func
	 * @return Returns aggregated value using specified function.
	 */
	public TSource aggregate(Function2<TSource, TSource, TSource> func);

	/**
	 * @param predicate
	 * @return Returns true if all values in current collection fulfill the
	 *         specified predicate; otherwise false.
	 */
	public boolean all(Predicate<TSource> predicate);

	/**
	 * @return Returns true if current collection contains any element; otherwise
	 *         false.
	 */
	public boolean any();

	/**
	 * @param predicate
	 * @return Returns true if any element from current collection fulfill the
	 *         specified predicate; otherwise false.
	 */
	public boolean any(Predicate<TSource> predicate);

	/**
	 * @return Converts current JLinq expression to {@link Iterable}.
	 */
	public IJLinqWrapper<TSource> asIterable();

	/**
	 * @param func
	 * @return Converts current JLinq expression to {@link INumberJLinqWrapper}
	 *         which allows for arithmetic operations (average, max, min, sum).
	 * @throws IllegalAccessException
	 */
	public <TNumber extends Number & Comparable<TNumber>> INumberJLinqWrapper<TNumber> asNumbered(
			Function<TSource, TNumber> func) throws IllegalAccessException;

	/**
	 * @param options
	 * @return Returns the collection on which the methods will be executed in
	 *         parallel.
	 */
	public IParallelJLinqWrapper<TSource> asParallel(IParallelQueryOptions options) throws IllegalAccessException;

	/**
	 * @param func
	 * @return Casts each element from current collection using specified function.
	 */
	public <TResult> IJLinqWrapper<TResult> cast(Function<TSource, TResult> func);

	/**
	 * @param second
	 * @return Contats current collection with the one specified in the parameter.
	 */
	public IJLinqWrapper<TSource> concat(Iterable<TSource> second);

	/**
	 * @param value
	 * @return Returns true if the current collection contains the specified value;
	 *         otherwise false.
	 */
	public boolean contains(TSource value);

	/**
	 * @param value
	 * @param comparator
	 * @return Returns true if the current collection contains the specified value
	 *         using specified Comparator; otherwise false.
	 */
	public boolean contains(TSource value, Comparator<TSource> comparator);

	/**
	 * @return Returns the number of elements in current collection. For more items
	 *         than Integer can hold, please see: {@link #longCount()}.
	 */
	public int count();

	/**
	 * @param predicate
	 * @return Returns the number of elements in current collection using specified
	 *         Predicate.
	 */
	public int count(Predicate<TSource> predicate);

	/**
	 * @return Returns null if the current collection is empty; otherwise, returns
	 *         this collection.
	 */
	public IJLinqWrapper<TSource> defaultIfEmpty();

	/**
	 * @param defaultValue
	 * @return Returns defaultValue if the current collection is empty; otherwise,
	 *         returns this collection.
	 */
	public IJLinqWrapper<TSource> defaultIfEmpty(TSource defaultValue);

	/**
	 * @return Returns distinct elements from current collection.
	 */
	public IJLinqWrapper<TSource> distinct();

	/**
	 * @param index
	 * @return Returns element at specified index from current collection.
	 */
	public TSource elementAt(int index);

	/**
	 * @param index
	 * @return Returns element at specified index from current collection or null
	 *         value if index is out of range.
	 */
	public TSource elementAtOrDefault(int index);

	/**
	 * @return Returns an empty collection of specified type.
	 */
	public IJLinqWrapper<TSource> empty();

	/**
	 * @param second
	 * @return Returns the collection which contains the difference of current
	 *         collection and the one specified in the argument.
	 */
	public IJLinqWrapper<TSource> except(Iterable<TSource> second);

	/**
	 * @return Returns the first element from current collection.
	 */
	public TSource first();

	/**
	 * @param predicate
	 * @return Returns the first element from current collection which fulfill the
	 *         predicate.
	 */
	public TSource first(Predicate<TSource> predicate);

	/**
	 * @return Returns the first element from current collection or null if the
	 *         collection is empty.
	 */
	public TSource firstOrDefault();

	/**
	 * @param predicate
	 * @return Returns the first element from current collection which fulfill the
	 *         predicate or null if the collection is empty.
	 */
	public TSource firstOrDefault(Predicate<TSource> predicate);

	// TODO: Add here GroupBy methods

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> groupJoin(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, Iterable<TInner>, TResult> resultSelector);

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> groupJoin(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, Iterable<TInner>, TResult> resultSelector, Comparator<TKey> comparator);

	/**
	 * @param element
	 * @return Returns the index of specified element in current collection. If the
	 *         element wasn't found, exception will be thrown.
	 */
	public int indexOf(TSource element);

	/**
	 * @param second
	 * @return Returns the intersection of current collection and the one specified
	 *         in the collection.
	 */
	public IJLinqWrapper<TSource> intersect(Iterable<TSource> second);

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector);

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector, Comparator<TKey> comparator);

	/**
	 * @return Returns the last element of current collection.
	 */
	public TSource last();

	/**
	 * @param predicate
	 * @return Returns the last element of current collection using the specified
	 *         predicate.
	 */
	public TSource last(Predicate<TSource> predicate);

	/**
	 * @return Returns the last element of current collection or null if the
	 *         collection is empty.
	 */
	public TSource lastOrDefault();

	/**
	 * @param predicate
	 * @return Returns the last element of current collection using the specified
	 *         predicate or null if the collection is empty.
	 */
	public TSource lastOrDefault(Predicate<TSource> predicate);

	/**
	 * @return Returns the number of elements in current collection.
	 */
	public long longCount();

	/**
	 * @param predicate
	 * @return Returns the number of elements in current collection using the
	 *         specified predicate.
	 */
	public long longCount(Predicate<TSource> predicate);

	// TODO: Add here OrderBy and OrderByDescending methods

	/**
	 * @param start Start number from which the collection will be generated.
	 * @param count Number of elements in the returned collection.
	 * @return Returns the collection which contains generated elements.
	 */
	public IJLinqWrapper<Integer> range(int start, int count);

	/**
	 * @param element
	 * @param count
	 * @return Returns the collection which contains the specified number of the
	 *         same elements.
	 */
	public IJLinqWrapper<TSource> repeat(TSource element, int count);

	/**
	 * @param index    Index on which element will be changed.
	 * @param newValue New value which will replace the old value.
	 * @return Returns the collection which will have replaced element at specified
	 *         index to the new one.
	 */
	public IJLinqWrapper<TSource> replaceAt(int index, TSource newValue);

	/**
	 * @param newValue  New value which will replace the old value.
	 * @param predicate Predicate which determine which value must be replaced.
	 * @return Returns the collection which will have replaced all the elements,
	 *         which fulfill the predicate, to the new one.
	 */
	public IJLinqWrapper<TSource> replaceMultiple(TSource newValue, Predicate<TSource> predicate);

	/**
	 * @return Returns the current collection but with reversed order.
	 * @throws IllegalAccessException
	 */
	public IJLinqWrapper<TSource> reverse() throws IllegalAccessException;

	/**
	 * @param selector
	 * @return Returns the elements projected using specified selector.
	 */
	public <TResult> IJLinqWrapper<TResult> select(Function<TSource, TResult> selector);

	/**
	 * @param selector
	 * @return Returns collection which is build of all projected collections.
	 */
	public <TResult> IJLinqWrapper<TResult> selectMany(Function<TSource, Iterable<TResult>> selector);

	/**
	 * @param second
	 * @return Returns true if the collections are equal; otherwise false.
	 */
	public boolean sequenceEqual(Iterable<TSource> second);

	/**
	 * @param second
	 * @param comparator
	 * @return Returns true if the collections are equal using specified comparator;
	 *         otherwise false.
	 */
	public boolean sequenceEqual(Iterable<TSource> second, Comparator<TSource> comparator);

	/**
	 * @return Returns the only element in the collection and throws error if the
	 *         collection contains more elements.
	 */
	public TSource single();

	/**
	 * @param predicate
	 * @return Returns the only element in the collection using the specified
	 *         predicate and throws error if the collection contains more elements.
	 */
	public TSource single(Predicate<TSource> predicate);

	/**
	 * @return Returns the only element in the collection, if the collection is
	 *         empty returns null; throws exception if collection contains more than
	 *         one element.
	 */
	public TSource singleOrDefault();

	/**
	 * @param predicate
	 * @return Returns the only element in the collection using the specified
	 *         predicate, if the collection is empty returns null; throws exception
	 *         if collection contains more than one element.
	 */
	public TSource singleOrDefault(Predicate<TSource> predicate);

	/**
	 * @param count
	 * @return Returns the rest of the collection after skipping the specified
	 *         number of elements.
	 */
	public IJLinqWrapper<TSource> skip(int count);

	/**
	 * @param predicate
	 * @return Returns the rest of the collection starting from the point where
	 *         predicate returned false.
	 */
	public IJLinqWrapper<TSource> skipWhile(Predicate<TSource> predicate);

	/**
	 * @param count
	 * @return Returns the specified number of elements from the start of the
	 *         collection.
	 * @throws IllegalAccessException
	 */
	public IJLinqWrapper<TSource> take(int count) throws IllegalAccessException;

	/**
	 * @param predicate
	 * @return Returns the collection from the start of the current collection and
	 *         until the specified predicate is fulfilled.
	 * @throws IllegalAccessException
	 */
	public IJLinqWrapper<TSource> takeWhile(Predicate<TSource> predicate) throws IllegalAccessException;

	/**
	 * @return Converts current collection to an Array.
	 * @throws IllegalAccessException
	 */
	public TSource[] toArray() throws IllegalAccessException;

	/**
	 * @return Converts current collection to {@link List}.
	 * @throws IllegalAccessException
	 */
	public List<TSource> toList();

	/**
	 * @param keySelector     Selects key for the {@link Map}.
	 * @param elementSelector Selects element for the {@link Map}.
	 * @return Converts current collection to {@link Map}.
	 * @throws IllegalAccessException
	 */
	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector) throws IllegalAccessException;

	/**
	 * @param keySelector     Selects key for the {@link Map}.
	 * @param elementSelector Selects element for the {@link Map}.
	 * @param comparator      Compares elements which will be added to {@link Map}.
	 * @return Converts current collection to {@link Map}.
	 * @throws IllegalAccessException
	 */
	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector, Comparator<TKey> comparator) throws IllegalAccessException;

	/**
	 * @param keySelector Selects key for the {@link Map}.
	 * @return Converts current collection to {@link Map}. Where the value of the
	 *         {@link Map} element is the source element.
	 * @throws IllegalAccessException
	 */
	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector) throws IllegalAccessException;

	/**
	 * @param keySelector Selects key for the {@link Map}.
	 * @param comparator  Compares elements which will be added to {@link Map}.
	 * @return Converts current collection to {@link Map}. Where the value of the
	 *         {@link Map} element is the source element.
	 * @throws IllegalAccessException
	 */
	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector, Comparator<TKey> comparator)
			throws IllegalAccessException;

	/**
	 * @return Converts current collection to {@link Set}.
	 * @throws IllegalAccessException
	 */
	public Set<TSource> toSet() throws IllegalAccessException;

	/**
	 * @param second
	 * @return Returns the collection which is the union of the current collection
	 *         with the one specified in the argument.
	 * @throws IllegalAccessException
	 */
	public IJLinqWrapper<TSource> union(Iterable<TSource> second) throws IllegalAccessException;

	/**
	 * @param predicate
	 * @return Returns the collection of elements which fulfill the predicate.
	 * @throws IllegalAccessException
	 */
	public IJLinqWrapper<TSource> where(Predicate<TSource> predicate) throws IllegalAccessException;

	/**
	 * @param second
	 * @param resultSelector Function that specifies how to connect two elements.
	 * @return Returns the collection of the elements which are connected based on
	 *         the function.
	 * @throws IllegalAccessException
	 */
	public <TSecond, TResult> IJLinqWrapper<TResult> zip(Iterable<TSecond> second,
			Function2<TSource, TSecond, TResult> resultSelector) throws IllegalAccessException;
}
