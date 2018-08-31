package jlinq.queryable;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import jlinq.queryable.interfaces.IExecuteQuery;
import jlinq.queryable.interfaces.IQueryableJLinqWrapper;

/**
 * 
 * Iterator made specially for the result from {@link IQueryableJLinqWrapper}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
final class QueryableIterator<TSource> implements Iterator<TSource>, Iterable<TSource> {

	/**
	 * Model which represents elements in data source.
	 */
	private final Class<TSource> modelClass;
	/**
	 * Delegate of a method to execute inner query.
	 */
	private final IExecuteQuery executeQueryMethod;
	/**
	 * Contains the result from the data source.
	 */
	private ResultSet results;
	/**
	 * Contains information if the inner query was executed.
	 */
	private boolean queryExecuted;
	/**
	 * Current element.
	 */
	private TSource current;

	public QueryableIterator(Class<TSource> modelClass, IExecuteQuery executer) {
		this.modelClass = modelClass;
		this.executeQueryMethod = executer;
		this.queryExecuted = false;
	}

	public Iterator<TSource> iterator() {
		return this;
	}

	public boolean hasNext() {
		if (!this.queryExecuted) {
			this.results = this.executeQueryMethod.executeQuery();
			this.queryExecuted = true;
		}

		try {
			while (this.results.next()) {
				this.current = this.parseCurrentElementFromDataSource();
				return true;
			}
			this.queryExecuted = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public TSource next() {
		return this.current;
	}

	/**
	 * Main method for parsing row data to the specified model.
	 * 
	 * @return Returns parsed element from current row of data from data source.
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	private TSource parseCurrentElementFromDataSource()
			throws InstantiationException, IllegalAccessException, SQLException {
		// TODO: Add support for the model classes which contains parameterized
		// constructors.
		TSource element = this.modelClass.newInstance();

		// Assign fields with values.
		for (Field modelField : this.modelClass.getFields()) {
			String fieldName = modelField.getName(); // This name should be equal with the name of the SQL column.
			Object columnValue = this.results.getObject(fieldName);
			modelField.set(element, columnValue);
		}

		return element;
	}
}
