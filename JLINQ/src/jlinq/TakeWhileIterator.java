package jlinq;

import java.util.function.Predicate;

class TakeWhileIterator<TSource> extends IteratorBase<TSource> {

	private Iterable<TSource> source;
	private Predicate<TSource> predicate;
	private int count;
	private int index;

	public TakeWhileIterator(Iterable<TSource> source, Predicate<TSource> predicate) {
		this.source = source;
		this.predicate = predicate;
		this.count = JLinq.count(this.source);
		this.index = 0;
	}

	public boolean hasNext() {
		if (this.index < this.count) {
			this.current = JLinq.elementAt(this.source, this.index);
			this.index++;
			if (this.predicate.test(this.current)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
}
