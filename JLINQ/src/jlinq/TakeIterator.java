package jlinq;

class TakeIterator<TSource> extends IteratorBase<TSource> {

	private Iterable<TSource> source;
	private int count;
	private int index;

	public TakeIterator(Iterable<TSource> source, int count) {
		this.source = source;
		this.count = count;
		this.index = 0;
	}

	public boolean hasNext() {
		if (this.index < this.count) {
			this.current = JLinq.elementAt(this.source, this.index);
			this.index++;
			return true;
		}
		return false;
	}
}
