package jlinq.queryable;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.functions.Function2;
import jlinq.interfaces.IJLinqWrapper;

/**
 * 
 * Executes query operations in memory.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public final class InMemoryQueryableWrapper<TSource> extends AbstractQueryableWrapper<TSource> {

	/**
	 * Source collection on which all the methods will be executed.
	 */
	private IJLinqWrapper<TSource> source;

	public InMemoryQueryableWrapper(IJLinqWrapper<TSource> source) {
		super(null);
		this.source = source;
	}

	public IJLinqWrapper<TSource> asIterable() {
		return this.source;
	}

	public TSource average() {
		throw new UnsupportedOperationException("Not supported by InMemoryQueryableWrapper");
	}

	public int count() {
		return this.source.count();
	}

	public IQueryableJLinqWrapper<TSource> distinct() {
		this.source = this.source.distinct();
		return this;
	}

	public <TInner, TKey, TResult> IQueryableJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector) {
		return new InMemoryQueryableWrapper<>(
				this.source.join(inner, outerKeySelector, innerKeySelector, resultSelector));
	}

	public <TInner, TKey, TResult> IQueryableJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector, Comparator<TKey> comparator) {
		return new InMemoryQueryableWrapper<>(
				this.source.join(inner, outerKeySelector, innerKeySelector, resultSelector, comparator));
	}

	public TSource max() {
		throw new UnsupportedOperationException("Not supported by InMemoryQueryableWrapper");
	}

	public TSource min() {
		throw new UnsupportedOperationException("Not supported by InMemoryQueryableWrapper");
	}

	public IQueryableJLinqWrapper<TSource> offset(int count) {
		this.source = this.source.skip(count);
		return this;
	}

	public <TKey extends Comparable<TKey>> IQueryableJLinqWrapper<TSource> orderBy(
			Function<TSource, TKey> keySelector) {
		this.source = this.source.orderBy(keySelector);
		return this;
	}

	public <TKey extends Comparable<TKey>> IQueryableJLinqWrapper<TSource> orderByDescending(
			Function<TSource, TKey> keySelector) {
		this.source = this.source.orderByDescending(keySelector);
		return this;
	}

	public <TResult> IQueryableJLinqWrapper<TResult> select(Function<TSource, TResult> selector) {
		return new InMemoryQueryableWrapper<>(this.source.select(selector));
	}

	public IQueryableJLinqWrapper<TSource> union(Iterable<TSource> second) throws IllegalAccessException {
		this.source = this.source.union(second);
		return this;
	}

	public IQueryableJLinqWrapper<TSource> where(Predicate<TSource> predicate) throws IllegalAccessException {
		this.source = this.source.where(predicate);
		return this;
	}

	public Iterator<TSource> iterator() {
		return this.source.iterator();
	}
}
