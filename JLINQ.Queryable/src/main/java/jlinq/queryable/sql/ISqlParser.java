package jlinq.queryable.sql;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * 
 * Used as a facade for different options for parsing lambdas to SQL queries.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public interface ISqlParser {

	/**
	 * @param func
	 * @return Returns the SQL query from given {@link Function}.
	 */
	public <TSource, TReturn> String toSql(Function<TSource, TReturn> func);

	/**
	 * @param predicate
	 * @return Returns the SQL query from given {@link Predicate}.
	 */
	public <TSource> String toSql(Predicate<TSource> predicate);
}