package jlinq;

import java.util.Iterator;
import java.util.function.Predicate;

class WhereIterator<TSource> extends IteratorBase<TSource> {

	private Iterable<TSource> source;
	private Iterator<TSource> sourceIterator;
	private Predicate<TSource> predicate;

	public WhereIterator(Iterable<TSource> source, Predicate<TSource> predicate) {
		this.source = source;
		this.sourceIterator = this.source.iterator();
		this.predicate = predicate;
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext()) {
			TSource element = this.sourceIterator.next();
			if (this.predicate.test(element)) {
				this.current = element;
				return true;
			}
		}
		return false;
	}
}