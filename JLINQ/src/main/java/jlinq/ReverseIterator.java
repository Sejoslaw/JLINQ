package jlinq;

import java.util.List;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class ReverseIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private List<TSource> array;
	private int index;

	public ReverseIterator(Iterable<TSource> source) {
		super(source);

		this.array = JLinq.toList(this.source);
		this.index = this.array.size() - 1;
	}

	public boolean hasNext() {
		while (this.index >= 0) {
			this.current = this.array.get(this.index);
			this.index--;
			return true;
		}
		return false;
	}
}