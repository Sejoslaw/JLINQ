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
	/**
	 * Name of the table which contains the TSource model fields. Make sure that the
	 * names of the table columns are equal with the names of the model fields.
	 */
	protected final String tableName;

	public AbstractQueryableWrapper(Connection connection) {
		this.connection = connection;
		this.tableName = this.parseTableNameFromGenericArgument();
	}

	public AbstractQueryableWrapper(Connection connection, String tableName) {
		this.connection = connection;
		this.tableName = tableName;
	}
}