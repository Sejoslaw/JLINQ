package jlinq.queryable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import jlinq.JLinq;
import jlinq.JLinqWrapper;
import jlinq.interfaces.IJLinqWrapper;
import jlinq.queryable.interfaces.IExecuteQuery;
import jlinq.queryable.interfaces.IQueryableJLinqWrapper;

/**
 * 
 * Abstract implementation of the {@link IQueryableJLinqWrapper}.
 * Implementations for specific databases should extend this class. The #1 rule
 * for working with queryable framework is that the model class MUST HAVE field
 * names equal with the names of the table columns.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource> Model type which should have fields named the same as the
 *        names of the database columns.
 */
public abstract class AbstractQueryableJLinqWrapper<TSource> implements IQueryableJLinqWrapper<TSource> {

	/**
	 * Class of the currently used model.
	 */
	protected final Class<TSource> modelClass;
	/**
	 * Connection used by JLINQ to execute methods on data source.
	 */
	protected final Connection connection;
	/**
	 * Name of the table which contains the TSource model fields. Make sure that the
	 * names of the table columns are equal with the names of the model fields.
	 */
	protected final String tableName;

	/**
	 * Iterator used to iterate over the query result.
	 */
	private final QueryableIterator<TSource> iterator;

	/**
	 * Query which will be executed on specified data source. This is what every
	 * queryable wrapper should modify.
	 */
	protected String query;

	public AbstractQueryableJLinqWrapper(Class<TSource> modelClass, Connection connection) {
		this(modelClass, connection, modelClass.getName());
	}

	public AbstractQueryableJLinqWrapper(Class<TSource> modelClass, Connection connection, String tableName) {
		this.modelClass = modelClass;
		this.connection = connection;
		this.tableName = tableName;

		// Handle iterating over query result.
		IExecuteQuery executer = () -> this.executeQuery();
		this.iterator = new QueryableIterator<>(this.modelClass, executer);
	}

	public IJLinqWrapper<TSource> asIterable() {
		List<TSource> source = JLinq.toList(this); // Force query to execute.
		return new JLinqWrapper<>(source);
	}

	public int count() {
		return JLinq.count(this);
	}

	public Iterator<TSource> iterator() {
		return this.iterator;
	}

	/**
	 * @return Returns the {@link ResultSet} from the executed query.
	 * @throws SQLException
	 */
	private ResultSet executeQuery() {
		if (this.query == null) {
			this.query = "SELECT * FROM " + this.tableName;
		}

		try {
			Statement statement = this.connection.createStatement();
			ResultSet rs = statement.executeQuery(this.query);
			return rs;
		} catch (SQLException e) { // It must be in try-catch since the iterator cannot throws any exception.
			e.printStackTrace();
			return null;
		}
	}
}