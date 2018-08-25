package jlinq.grouping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * Default implementation of {@link IGroup}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TKey>
 * @param <TElement>
 */
public final class DefaultGroup<TKey, TElement> implements IGroup<TKey, TElement> {

	private TKey key;
	private Collection<TElement> elements;

	public DefaultGroup(TKey key) {
		this.key = key;
		this.elements = new ArrayList<>();
	}

	public void add(TElement element) {
		this.elements.add(element);
	}

	public Iterator<TElement> iterator() {
		return this.elements.iterator();
	}

	public TKey getKey() {
		return this.key;
	}
}