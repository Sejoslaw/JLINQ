package jlinq;

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

	private Iterable<? extends Iterable<TSourceElement>> source;
	private Iterator<? extends Iterable<TSourceElement>> sourceIterator;

	private Iterable<TSourceElement> currentCollection;
	private Iterator<TSourceElement> currentCollectionIterator;

	public CollectionOfCollectionsIterator(Iterable<? extends Iterable<TSourceElement>> source) {
		this.source = source;
		if (this.source != null) {
			this.sourceIterator = this.source.iterator();
		}
	}

	public boolean hasNext() {
		while (this.sourceIterator.hasNext() || this.currentCollectionIterator.hasNext()) {
			if (this.currentCollection == null) {
				this.currentCollection = this.sourceIterator.next();
				this.currentCollectionIterator = this.currentCollection.iterator();
			}

			if (this.currentCollectionIterator.hasNext()) {
				this.current = this.currentCollectionIterator.next();
			} else if (this.sourceIterator.hasNext()) {
				this.currentCollection = this.sourceIterator.next();
				this.currentCollectionIterator = this.currentCollection.iterator();
			} else {
				return false;
			}
			return true;
		}
		return false;
	}
}
