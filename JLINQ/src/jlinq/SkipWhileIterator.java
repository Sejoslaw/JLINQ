package jlinq;

import java.util.function.Predicate;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class SkipWhileIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private Predicate<TSource> predicate;
	private boolean isRightElement;;

	public SkipWhileIterator(Iterable<TSource> source, Predicate<TSource> predicate) {
		super(source);

		this.predicate = predicate;
		this.isRightElement = false;
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext()) {
			TSource element = this.sourceIterator.next();
			if (!this.isRightElement && !this.predicate.test(element))
				this.isRightElement = true;
			if (this.isRightElement) {
				this.current = element;
				return true;
			}
		}
		return false;
	}
}
