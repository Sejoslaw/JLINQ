package jlinq.queryable.sql;

import java.sql.Connection;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.queryable.AbstractQueryableJLinqWrapper;
import jlinq.queryable.interfaces.IQueryableJLinqWrapper;

/**
 * 
 * Abstract layer in {@link IQueryableJLinqWrapper} hierarchy. Contains
 * information about {@link ISqlParser} which will be used for parsing
 * {@link Function} and {@link Predicate} to SQL string.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public abstract class SqlQueryableJLinqWrapper<TSource> extends AbstractQueryableJLinqWrapper<TSource> {

	/**
	 * Parser which can be used to parse lambdas to SQL statements. Facade for using
	 * external libraries.
	 */
	protected ISqlParser sqlParser;

	public SqlQueryableJLinqWrapper(Class<TSource> modelClass, Connection connection) {
		super(modelClass, connection);
	}

	public SqlQueryableJLinqWrapper(Class<TSource> modelClass, Connection connection, String tableName) {
		super(modelClass, connection, tableName);
	}

	/**
	 * @return Returns currently used {@link ISqlParser} for parsing lambdas to SQL
	 *         statements.
	 */
	public ISqlParser getSqlParser() {
		return this.sqlParser;
	}

	/**
	 * @param sqlParser
	 * @return Sets new {@link ISqlParser} and returns current
	 *         {@link SqlQueryableJLinqWrapper} for easier methods chain.
	 */
	public SqlQueryableJLinqWrapper<TSource> setSqlParser(ISqlParser sqlParser) {
		this.sqlParser = sqlParser;
		return this;
	}
}
