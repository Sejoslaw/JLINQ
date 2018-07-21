package jlinq;

import java.util.Iterator;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
abstract class SingleGenericTypeIterator<TSource, TResult> extends IteratorBase<TResult> {

	protected Iterable<TSource> source;
	protected Iterator<TSource> sourceIterator;

	public SingleGenericTypeIterator(Iterable<TSource> source) {
		this.source = source;
		if (this.source != null)
			this.sourceIterator = this.source.iterator();
	}
}
