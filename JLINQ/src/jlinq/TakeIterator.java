package jlinq;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class TakeIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private int count;
	private int index;

	public TakeIterator(Iterable<TSource> source, int count) {
		super(source);

		this.count = count;
		this.index = 0;
	}

	public boolean hasNext() {
		while ((this.index < this.count) && this.sourceIterator.hasNext()) {
			this.current = this.sourceIterator.next();
			this.index++;
			return true;
		}
		return false;
	}
}
