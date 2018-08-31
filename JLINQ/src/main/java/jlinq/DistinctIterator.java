package jlinq;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class DistinctIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private Set<TSource> set;

	public DistinctIterator(Iterable<TSource> source) {
		super(source);

		this.set = new HashSet<>();
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext()) {
			TSource element = this.sourceIterator.next();
			if (this.set.add(element)) {
				this.current = element;
				return true;
			}
		}
		return false;
	}
}
