package jlinq.grouping;

/**
 * 
 * Represents a group of elements.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TKey> Key by which the elements will be grouped.
 * @param <TElement> Type of grouped elements.
 */
public interface IGroup<TKey, TElement> extends Iterable<TElement> {

	/**
	 * @return Returns the key of current group.
	 */
	public TKey getKey();
}