package jlinq.interfaces;

/**
 * 
 * Contains methods which operates on numbered collections. Performs basic
 * arithmetic operations.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 * 
 * @param <TSource> Type of a collection on which current methods will be
 *        executed.
 */
public interface INumberJLinqWrapper<TSource extends Number & Comparable<TSource>> extends IJLinqWrapper<TSource> {

	/**
	 * @return Returns average value from current collection.
	 */
	public TSource average();

	/**
	 * @return Returns maximum value from current collection, using default
	 *         Comparable implementation.
	 */
	public TSource max();

	/**
	 * @return Returns minimum value from current collection, using default
	 *         Comparable implementation.
	 */
	public TSource min();

	/**
	 * @return Returns total summed value of all elements in current collection.
	 */
	public TSource sum();
}
