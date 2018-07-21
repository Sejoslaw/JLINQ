package jlinq;

import jlinq.functions.Function2;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TFirst>
 * @param <TSecond>
 * @param <TResult>
 */
class ZipIterator<TFirst, TSecond, TResult> extends DoubleGenericTypeIterator<TFirst, TSecond, TResult> {

	private Function2<TFirst, TSecond, TResult> resultSelector;

	public ZipIterator(Iterable<TFirst> first, Iterable<TSecond> second,
			Function2<TFirst, TSecond, TResult> resultSelector) {
		super(first, second);

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
