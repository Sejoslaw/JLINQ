package jlinq;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class ReplaceAtIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private int counter;
	private int index;
	private TSource newValue;

	public ReplaceAtIterator(Iterable<TSource> source, int index, TSource newValue) {
		super(source);

		this.index = index;
		this.newValue = newValue;
		this.counter = 0;
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext()) {
			if (this.index == this.counter) {
				this.current = this.newValue;
			} else {
				this.current = this.sourceIterator.next();
			}
			this.counter++;
			return true;
		}
		return false;
	}
}
