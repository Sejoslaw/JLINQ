package jlinq;

import java.util.function.Predicate;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class WhereIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private Predicate<TSource> predicate;

	public WhereIterator(Iterable<TSource> source, Predicate<TSource> predicate) {
		super(source);

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