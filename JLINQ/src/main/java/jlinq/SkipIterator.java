package jlinq;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class SkipIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private int count;

	public SkipIterator(Iterable<TSource> source, int count) {
		super(source);

		this.count = count;
	}

	public boolean hasNext() {
		if (this.count > 0) {
			while (this.sourceIterator.hasNext() && this.count > 0) {
				this.sourceIterator.next();
				this.count--;
			}
		}

		while (this.sourceIterator.hasNext() && this.count <= 0) {
			this.current = this.sourceIterator.next();
			return true;
		}
		return false;
	}
}
