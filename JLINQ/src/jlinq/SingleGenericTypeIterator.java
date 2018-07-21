package jlinq;

import java.util.Iterator;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
abstract class SingleGenericTypeIterator<TSource> extends IteratorBase<TSource> {

	protected Iterable<TSource> source;
	protected Iterator<TSource> sourceIterator;

	public SingleGenericTypeIterator(Iterable<TSource> source) {
		this.source = source;
		this.sourceIterator = this.source.iterator();
	}
}
