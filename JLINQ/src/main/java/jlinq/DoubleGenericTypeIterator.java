package jlinq;

import java.util.Iterator;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 * @param <TResult>
 */
abstract class DoubleGenericTypeIterator<TSource1, TSource2, TReturn> extends IteratorBase<TReturn> {

	protected Iterable<TSource1> first;
	protected Iterator<TSource1> firstIterator;
	protected Iterable<TSource2> second;
	protected Iterator<TSource2> secondIterator;

	public DoubleGenericTypeIterator(Iterable<TSource1> first, Iterable<TSource2> second) {
		this.first = first;
		if (this.first != null)
			this.firstIterator = this.first.iterator();

		this.second = second;
		if (this.second != null)
			this.secondIterator = this.second.iterator();
	}
}
