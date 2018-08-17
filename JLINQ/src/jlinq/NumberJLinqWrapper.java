package jlinq;

import jlinq.interfaces.INumberJLinqWrapper;

/**
 * 
 * Default implementation of {@link INumberJLinqWrapper} which can perform basic
 * arithmetic operations. For more detailed information about the methods,
 * please see: {@link INumberJLinqWrapper}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public class NumberJLinqWrapper<TSource extends Number & Comparable<TSource>> extends JLinqWrapper<TSource>
		implements INumberJLinqWrapper<TSource> {

	public NumberJLinqWrapper(Iterable<TSource> iterable) {
		this.iterable = iterable;
	}

	public TSource average() {
		Object sum = this.sum();
		int count = this.count();

		return this.ParseAverage(sum, count);
	}

	public TSource max() {
		if (this.count() <= 0) {
			return null;
		} else if (this.count() == 1) {
			return this.elementAt(0);
		} else {
			TSource max = this.elementAt(0);
			for (TSource number : this.iterable) {
				if (number.compareTo(max) > 0) {
					max = number;
				}
			}
			return max;
		}
	}

	public TSource min() {
		if (this.count() <= 0) {
			return null;
		} else if (this.count() == 1) {
			return this.elementAt(0);
		} else {
			TSource min = this.elementAt(0);
			for (TSource number : this.iterable) {
				if (number.compareTo(min) < 0) {
					min = number;
				}
			}
			return min;
		}
	}

	@SuppressWarnings("unchecked")
	public TSource sum() {
		Object sum = 0;
		for (TSource number : this.iterable) {
			sum = this.AddTwoValues(sum, number);
		}
		return (TSource) sum;
	}

	@SuppressWarnings("unchecked")
	private TSource AddTwoValues(Object sum, TSource number) {
		if (number instanceof Byte)
			return (TSource) (Object) (((Number) sum).byteValue() + ((Number) number).byteValue());
		else if (number instanceof Short)
			return (TSource) (Object) (((Number) sum).shortValue() + ((Number) number).shortValue());
		else if (number instanceof Integer)
			return (TSource) (Object) (((Number) sum).intValue() + ((Number) number).intValue());
		else if (number instanceof Long)
			return (TSource) (Object) (((Number) sum).longValue() + ((Number) number).longValue());
		else if (number instanceof Float)
			return (TSource) (Object) (((Number) sum).floatValue() + ((Number) number).floatValue());
		else if (number instanceof Double)
			return (TSource) (Object) (((Number) sum).doubleValue() + ((Number) number).doubleValue());
		else
			throw new ArithmeticException("Cannot perform an arithmetic operation.");
	}

	@SuppressWarnings("unchecked")
	private TSource ParseAverage(Object sum, int count) {
		if (sum instanceof Byte)
			return (TSource) (Object) (((Number) sum).byteValue() / count);
		else if (sum instanceof Short)
			return (TSource) (Object) (((Number) sum).shortValue() / count);
		else if (sum instanceof Integer)
			return (TSource) (Object) (((Number) sum).intValue() / count);
		else if (sum instanceof Long)
			return (TSource) (Object) (((Number) sum).longValue() / count);
		else if (sum instanceof Float)
			return (TSource) (Object) (((Number) sum).floatValue() / count);
		else if (sum instanceof Double)
			return (TSource) (Object) (((Number) sum).doubleValue() / count);
		else
			throw new ArithmeticException("Cannot perform an arithmetic operation.");
	}
}