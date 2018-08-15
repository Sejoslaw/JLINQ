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

	public TSource average();

	public TSource max();

	public TSource min();

	public TSource sum();
}
