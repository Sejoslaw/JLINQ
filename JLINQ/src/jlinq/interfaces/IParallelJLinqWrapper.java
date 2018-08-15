package jlinq.interfaces;

import java.util.function.Consumer;

/**
 * 
 * Contains methods which will help user to execute parallel operations.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource> Type of a collection on which current methods will be
 *        executed.
 */
public interface IParallelJLinqWrapper<TSource> extends IJLinqWrapper<TSource> {

	public void forAll(Consumer<TSource> action);
}
