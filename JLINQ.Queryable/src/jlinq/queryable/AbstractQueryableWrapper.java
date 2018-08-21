package jlinq.queryable;

import java.sql.Connection;

/**
 * 
 * Abstract implementation for common methods.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public abstract class AbstractQueryableWrapper<TSource> implements IQueryableJLinqWrapper<TSource> {

	/**
	 * Connection used by JLINQ to execute methods on data source.
	 */
	protected final Connection connection;

	public AbstractQueryableWrapper(Connection connection) {
		this.connection = connection;
	}
}