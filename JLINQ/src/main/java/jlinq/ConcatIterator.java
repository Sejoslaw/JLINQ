package jlinq;

import java.util.Iterator;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class ConcatIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private Iterable<TSource> second;
	private Iterator<TSource> secondIterator;

	public ConcatIterator(Iterable<TSource> first, Iterable<TSource> second) {
		super(first);

		this.second = second;
		this.secondIterator = this.second.iterator();
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext()) {
			this.current = this.sourceIterator.next();
			return true;
		}
		while (this.secondIterator.hasNext()) {
			this.current = this.secondIterator.next();
			return true;
		}
		return false;
	}
}
