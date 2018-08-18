package jlinq;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * Iterates over the collection of collections.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSourceElement>
 */
class CollectionOfCollectionsIterator<TSourceElement> extends IteratorBase<TSourceElement> {

	private Collection<? extends Collection<TSourceElement>> source;
	private Iterator<? extends Collection<TSourceElement>> sourceIterator;

	private Collection<TSourceElement> currentCollection;
	private Iterator<TSourceElement> currentCollectionIterator;

	public CollectionOfCollectionsIterator(Collection<? extends Collection<TSourceElement>> source) {
		this.source = source;
		if (this.source != null) {
			this.sourceIterator = this.source.iterator();
		}
	}

	public boolean hasNext() {
		// If has next collection which should be checked
		while (this.sourceIterator.hasNext() || this.currentCollectionIterator.hasNext()) {
			if (this.currentCollection == null) {
				this.currentCollection = this.sourceIterator.next();
				this.currentCollectionIterator = this.currentCollection.iterator();
			}

			if (this.currentCollectionIterator.hasNext()) {
				this.current = this.currentCollectionIterator.next();
			} else {
				this.currentCollection = this.sourceIterator.next();
				this.currentCollectionIterator = this.currentCollection.iterator();
			}
			return true;
		}
		return false;
	}
}
