package jlinq.comparators;

import java.util.Comparator;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public class DefaultComparator<TSource> implements Comparator<TSource> {

	public int compare(TSource o1, TSource o2) {
		if (o1 instanceof Comparable<?>) {
			return ((Comparable<TSource>) o1).compareTo(o2);
		}

		// Make sure to check if the objects are equal by default.
		if (o1 == o2) {
			return 0;
		}

		int hash1 = o1.hashCode();
		int hash2 = o2.hashCode();

		if (hash1 > hash2)
			return 1;
		else if (hash1 == hash2)
			return 0;
		else
			return -1;
	}
}
