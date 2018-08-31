package jlinq;

import java.util.Iterator;
import java.util.function.Function;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 * @param <TResult>
 * @param <TCollection>
 */
class SelectMany<TSource, TResult, TCollection extends Iterable<TResult>>
		extends SingleGenericTypeIterator<TSource, TResult> {

	private Function<TSource, Iterable<TResult>> selector;
	private Iterable<TResult> currentResult;
	private Iterator<TResult> currentResultIterator;

	public SelectMany(Iterable<TSource> source, Function<TSource, Iterable<TResult>> selector) {
		super(source);

		this.selector = selector;
	}

	public boolean hasNext() {
		while ((this.currentResult != null) && (this.currentResultIterator != null)
				&& (this.currentResultIterator.hasNext())) {
			this.current = this.currentResultIterator.next();
			return true;
		}
		while (this.sourceIterator.hasNext()) {
			TSource element = this.sourceIterator.next();
			this.currentResult = this.selector.apply(element);
			this.currentResultIterator = this.currentResult.iterator();
			return this.hasNext();
		}
		return false;
	}
}
