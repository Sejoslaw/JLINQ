package jlinq;

import java.util.Iterator;

import jlinq.functions.Function2;

class ZipIterator<TFirst, TSecond, TResult> extends IteratorBase<TResult> {

	private Iterable<TFirst> first;
	private Iterator<TFirst> firstIterator;
	private Iterable<TSecond> second;
	private Iterator<TSecond> secondIterator;
	private Function2<TFirst, TSecond, TResult> resultSelector;

	public ZipIterator(Iterable<TFirst> first, Iterable<TSecond> second,
			Function2<TFirst, TSecond, TResult> resultSelector) {
		this.first = first;
		this.firstIterator = this.first.iterator();
		this.second = second;
		this.secondIterator = this.second.iterator();
		this.resultSelector = resultSelector;
	}

	public boolean hasNext() {
		while (this.firstIterator.hasNext() && this.secondIterator.hasNext()) {
			TFirst el1 = this.firstIterator.next();
			TSecond el2 = this.secondIterator.next();
			this.current = this.resultSelector.apply(el1, el2);
			return true;
		}
		return false;
	}
}
