package jlinq.queryable.interfaces;

import java.sql.ResultSet;

import jlinq.queryable.AbstractQueryableJLinqWrapper;

/**
 * 
 * Used for passing the method which should execute query from the queryable
 * wrapper. For information see: {@link AbstractQueryableJLinqWrapper}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 */
public interface IExecuteQuery {
	public ResultSet executeQuery();
}
