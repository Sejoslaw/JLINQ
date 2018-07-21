package jlinq;

import java.util.function.Function;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 * @param <TResult>
 */
class CastIterator<TSource, TResult> extends SingleGenericTypeIterator<TSource, TResult> {

	private Function<TSource, TResult> func;

	public CastIterator(Iterable<TSource> source, Function<TSource, TResult> func) {
		super(source);

		this.func = func;
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext()) {
			TSource element = this.sourceIterator.next();
			this.current = this.func.apply(element);
			return true;
		}
		return false;
	}
}
