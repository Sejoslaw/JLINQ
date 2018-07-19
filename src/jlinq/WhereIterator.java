package jlinq;

import java.util.Iterator;
import java.util.function.Predicate;

class WhereIterator<TSource> extends IteratorBase<TSource> {
	
	public WhereIterator(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public boolean hasNext() {
	}
	
	public TSource next() {
	}
	
	public Iterator<TSource> iterator() {
		return this;
	}
}