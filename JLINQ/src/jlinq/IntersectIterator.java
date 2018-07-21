package jlinq;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class IntersectIterator<TSource> extends DoubleGenericTypeIterator<TSource, TSource, TSource> {

	private Set<TSource> set;

	public IntersectIterator(Iterable<TSource> first, Iterable<TSource> second) {
		super(first, second);

		this.set = new HashSet<TSource>();

		for (TSource element : this.second)
			this.set.add(element);
	}

	public boolean hasNext() {
		while (this.firstIterator.hasNext()) {
			TSource element = this.firstIterator.next();
			if (this.set.remove(element)) {
				this.current = element;
				return true;
			}
		}
		return false;
	}
}
