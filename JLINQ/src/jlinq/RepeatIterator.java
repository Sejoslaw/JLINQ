package jlinq;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class RepeatIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private TSource element;
	private int count;

	public RepeatIterator(TSource element, int count) {
		super(null);

		this.element = element;
		this.count = count;
	}

	public boolean hasNext() {
		while (this.count > 0) {
			this.current = element;
			this.count--;
			return true;
		}
		return false;
	}
}
