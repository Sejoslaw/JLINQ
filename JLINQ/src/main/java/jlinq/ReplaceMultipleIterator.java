package jlinq;

import java.util.function.Predicate;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class ReplaceMultipleIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private TSource newValue;
	private Predicate<TSource> predicate;

	public ReplaceMultipleIterator(Iterable<TSource> source, TSource newValue, Predicate<TSource> predicate) {
		super(source);

		this.newValue = newValue;
		this.predicate = predicate;
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext()) {
			TSource element = this.sourceIterator.next();
			if (this.predicate.test(element))
				this.current = this.newValue;
			else
				this.current = element;
			return true;
		}
		return false;
	}
}
