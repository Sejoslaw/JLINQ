package jlinq;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
class RangeIterator extends SingleGenericTypeIterator<Integer, Integer> {

	private int start;
	private int count;

	public RangeIterator(int start, int count) {
		super(null);

		this.start = start;
		this.count = count;
	}

	public boolean hasNext() {
		while (this.count > 0) {
			this.current = this.start; // Start from the number specified.
			this.start++;
			this.count--;
			return true;
		}
		return false;
	}
}
