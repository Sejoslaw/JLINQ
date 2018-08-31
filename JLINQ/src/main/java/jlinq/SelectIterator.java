package jlinq;

import java.util.function.Function;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 * @param <TResult>
 */
class SelectIterator<TSource, TResult> extends SingleGenericTypeIterator<TSource, TResult> {

	private Function<TSource, TResult> selector;

	public SelectIterator(Iterable<TSource> source, Function<TSource, TResult> selector) {
		super(source);

		this.selector = selector;
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext()) {
			TSource element = this.sourceIterator.next();
			this.current = this.selector.apply(element);
			return true;
		}
		return false;
	}
}
