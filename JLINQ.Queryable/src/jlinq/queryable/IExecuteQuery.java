package jlinq.queryable;

import java.sql.ResultSet;

/**
 * 
 * Used for passing the method which should execute query from the queryable
 * wrapper. For information see: {@link AbstractQueryableWrapper}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 */
public interface IExecuteQuery {
	public ResultSet executeQuery();
}
