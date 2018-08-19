package jlinq;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class ExceptIterator<TSource> extends DoubleGenericTypeIterator<TSource, TSource, TSource> {

	private Set<TSource> set;

	public ExceptIterator(Iterable<TSource> first, Iterable<TSource> second) {
		super(first, second);

		set = new HashSet<>();

		for (TSource element : this.second)
			this.set.add(element);
	}

	public boolean hasNext() {
		while (this.secondIterator.hasNext()) {
			TSource element = this.secondIterator.next();
			if (this.set.add(element)) {
				this.current = element;
				return true;
			}
		}
		return false;
	}
}
