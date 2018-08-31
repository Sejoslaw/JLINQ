package jlinq.queryable.interfaces;

import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.functions.Function2;
import jlinq.grouping.IGroup;
import jlinq.interfaces.IJLinqWrapper;

/**
 * 
 * Used to operate and execute queries on specified data source.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public interface IQueryableJLinqWrapper<TSource> extends Iterable<TSource> {

	/**
	 * @return Executes current query and converts results to {@link IJLinqWrapper}.
	 */
	public IJLinqWrapper<TSource> asIterable();

	/**
	 * @return Executes current query and returns the average value from all
	 *         returned values.
	 */
	public TSource average();

	/**
	 * @return Executes current query and returns the number of elements from
	 *         executed query.
	 */
	public int count();

	/**
	 * @return Adds distinct query to current query tree.
	 */
	public IQueryableJLinqWrapper<TSource> distinct();

	/**
	 * @param keySelector     Specified key for each element.
	 * @param elementSelector Element which will be added to right group.
	 * @return Returns collection of grouped elements.
	 */
	public <TKey, TElement> IQueryableJLinqWrapper<IGroup<TKey, TElement>> groupBy(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector);

	/**
	 * @param inner            Collection which will be joined with current
	 *                         collection.
	 * @param outerKeySelector Selects key from current collection.
	 * @param innerKeySelector Selects key from inner collection.
	 * @param resultSelector   Returns a result of joining outer and inner element.
	 * @return Returns a collection which is build of an object-pair results.
	 */
	public <TInner, TKey, TResult> IQueryableJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector);

	/**
	 * @return Executes current query and returns the maximum value from query
	 *         result.
	 */
	public TSource max();

	/**
	 * @return Executes current query and returns the minimum value from query
	 *         result.
	 */
	public TSource min();

	/**
	 * @param count
	 * @return Adds the offset (skip) query to current query tree.
	 */
	public IQueryableJLinqWrapper<TSource> offset(int count);

	/**
	 * @param keySelector
	 * @return Returns ordered collection using specified key.
	 */
	public <TKey extends Comparable<TKey>> IQueryableJLinqWrapper<TSource> orderBy(Function<TSource, TKey> keySelector);

	/**
	 * @param keySelector
	 * @return Returns ordered collection using specified key. Returned collection
	 *         will have a descending order.
	 */
	public <TKey extends Comparable<TKey>> IQueryableJLinqWrapper<TSource> orderByDescending(
			Function<TSource, TKey> keySelector);

	/**
	 * @param selector
	 * @return Adds select query to current query tree.
	 */
	public <TResult> IQueryableJLinqWrapper<TResult> select(Function<TSource, TResult> selector);

	/**
	 * @param second
	 * @return Adds union query to current query tree.
	 */
	public IQueryableJLinqWrapper<TSource> union(Iterable<TSource> second);

	/**
	 * @param predicate
	 * @return Adds where query to current query tree.
	 */
	public IQueryableJLinqWrapper<TSource> where(Predicate<TSource> predicate);
}
