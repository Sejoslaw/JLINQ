package jlinq.queryable.mysql;

import java.sql.Connection;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.functions.Function2;
import jlinq.grouping.IGroup;
import jlinq.interfaces.IJLinqWrapper;
import jlinq.queryable.AbstractQueryableWrapper;
import jlinq.queryable.IQueryableJLinqWrapper;

/**
 * 
 * Wrapper for MySQL database. For more details informations see:
 * {@link AbstractQueryableWrapper}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public class MySqlQueryableJLinqWrapper<TSource> extends AbstractQueryableWrapper<TSource> {

	/**
	 * Version of the current build.
	 */
	public static final String VERSION = "0.5.0";

	public MySqlQueryableJLinqWrapper(Class<TSource> modelClass, Connection connection) {
		super(modelClass, connection);
	}

	public MySqlQueryableJLinqWrapper(Class<TSource> modelClass, Connection connection, String tableName) {
		super(modelClass, connection, tableName);
	}

	@Override
	public IJLinqWrapper<TSource> asIterable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TSource average() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IQueryableJLinqWrapper<TSource> distinct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TKey, TElement> IQueryableJLinqWrapper<IGroup<TKey, TElement>> groupBy(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TInner, TKey, TResult> IQueryableJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TSource max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TSource min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQueryableJLinqWrapper<TSource> offset(int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TKey extends Comparable<TKey>> IQueryableJLinqWrapper<TSource> orderBy(
			Function<TSource, TKey> keySelector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TKey extends Comparable<TKey>> IQueryableJLinqWrapper<TSource> orderByDescending(
			Function<TSource, TKey> keySelector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <TResult> IQueryableJLinqWrapper<TResult> select(Function<TSource, TResult> selector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQueryableJLinqWrapper<TSource> union(Iterable<TSource> second) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IQueryableJLinqWrapper<TSource> where(Predicate<TSource> predicate) {
		// TODO Auto-generated method stub
		return null;
	}
}