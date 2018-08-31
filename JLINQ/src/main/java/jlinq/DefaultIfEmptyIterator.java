package jlinq;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
class DefaultIfEmptyIterator<TSource> extends SingleGenericTypeIterator<TSource, TSource> {

	private TSource defaultValue;
	private boolean defaultUsed;

	public DefaultIfEmptyIterator(Iterable<TSource> source, TSource defaultValue) {
		super(source);

		this.defaultValue = defaultValue;
		this.defaultUsed = false;
	}

	public boolean hasNext() {
		if (this.sourceIterator.hasNext()) {
			while (this.sourceIterator.hasNext()) {
				this.current = this.sourceIterator.next();
				return true;
			}
		} else if (!this.defaultUsed) {
			this.current = this.defaultValue;
			this.defaultUsed = true;
			return true;
		}
		return false;
	}
}
