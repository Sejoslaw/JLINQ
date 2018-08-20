package jlinq.queryable;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.functions.Function2;

/**
 * 
 * Used to operate and execute queries on specified data source.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public interface IQueryableJLinqWrapper<TSource> {

	/**
	 * @return Executes current query and converts results to {@link IQueryable}.
	 */
	public IQueryable<TSource> asIterable();

	/**
	 * @return Executes current query and returns the average value from all returns
	 *         values.
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

	// TODO: Add here GroupBy methods

	public <TInner, TKey, TResult> IQueryableJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector);

	public <TInner, TKey, TResult> IQueryableJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector, Comparator<TKey> comparator);

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

	// TODO: Add here OrderBy and OrderByDescending methods

	/**
	 * @param selector
	 * @return Adds select query to current query tree.
	 */
	public <TResult> IQueryableJLinqWrapper<TResult> select(Function<TSource, TResult> selector);

	/**
	 * @param second
	 * @return Adds union query to current query tree.
	 * @throws IllegalAccessException
	 */
	public IQueryableJLinqWrapper<TSource> union(Iterable<TSource> second) throws IllegalAccessException;

	/**
	 * @param predicate
	 * @return Adds where query to current query tree.
	 * @throws IllegalAccessException
	 */
	public IQueryableJLinqWrapper<TSource> where(Predicate<TSource> predicate) throws IllegalAccessException;
}
