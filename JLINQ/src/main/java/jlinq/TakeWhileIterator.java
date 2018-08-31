package jlinq;

import java.util.function.Predicate;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class TakeWhileIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private Predicate<TSource> predicate;

	public TakeWhileIterator(Iterable<TSource> source, Predicate<TSource> predicate) {
		super(source);

		this.predicate = predicate;
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext()) {
			this.current = this.sourceIterator.next();
			if (this.predicate.test(this.current)) {
				return true;
			}
			return false;
		}
		return false;
	}
}
