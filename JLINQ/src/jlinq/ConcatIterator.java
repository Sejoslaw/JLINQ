package jlinq;

import java.util.Iterator;

class ConcatIterator<TSource> extends SingleGenericTypeIterator<TSource> {

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
