package jlinq;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class UnionIterator<TSource> extends DoubleGenericTypeIterator<TSource, TSource, TSource> {

	private Set<TSource> set;

	public UnionIterator(Iterable<TSource> first, Iterable<TSource> second) {
		super(first, second);

		this.set = new HashSet<TSource>();
	}

	public boolean hasNext() {
		if (this.checkSingle(this.firstIterator))
			return true;
		if (this.checkSingle(this.secondIterator))
			return true;

		return false;
	}

	private boolean checkSingle(Iterator<TSource> iterator) {
		while (iterator.hasNext()) {
			TSource element = iterator.next();
			if (this.set.add(element)) {
				this.current = element;
				return true;
			}
		}
		return false;
	}
}
