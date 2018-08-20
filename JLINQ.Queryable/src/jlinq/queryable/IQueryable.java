package jlinq.queryable;

/**
 * 
 * Represents the core interface which holds the data received from data source.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public interface IQueryable<TSource> extends Iterable<TSource> {

	/**
	 * @return Returns the type of the elements which will be returned from query.
	 */
	public Class<TSource> getElementType();
}