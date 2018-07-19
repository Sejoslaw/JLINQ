package jlinq;

import java.util.Iterator;

/**
 * Base for all iterators.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <T>
 */
abstract class IteratorBase<TSource> implements Iterator<TSource>, Iterable<TSource> {
	
	/**
	 * Current element.
	 */
	protected TSource current;
}
