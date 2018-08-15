package jlinq.interfaces;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.JLinq;
import jlinq.functions.Function2;

/**
 * 
 * For more information see {@link JLinq}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource> Type of a collection on which current methods will be
 *        executed.
 */
public interface IJLinqWrapper<TSource> {

	public TSource aggregate(Function2<TSource, TSource, TSource> func);

	public boolean all(Predicate<TSource> predicate);

	public boolean any();

	public boolean any(Predicate<TSource> predicate);

	public IJLinqWrapper<TSource> asIterable();

	public <TNumber extends Number & Comparable<TNumber>> INumberJLinqWrapper<TNumber> asNumbered(
			Function<TSource, TNumber> func) throws IllegalAccessException;

	// public IParallelJLinqWrapper<TSource> asParallel(); // TODO: Add implementation

	public <TResult> IJLinqWrapper<TResult> cast(Function<TSource, TResult> func);

	public IJLinqWrapper<TSource> concat(Iterable<TSource> second);

	public boolean contains(TSource value);

	public boolean contains(TSource value, Comparator<TSource> comparator);

	public int count();

	public int count(Predicate<TSource> predicate);

	public IJLinqWrapper<TSource> defaultIfEmpty();

	public IJLinqWrapper<TSource> defaultIfEmpty(TSource defaultValue);

	public IJLinqWrapper<TSource> distinct();

	public TSource elementAt(int index);

	public TSource elementAtOrDefault(int index);

	public IJLinqWrapper<TSource> empty();

	public IJLinqWrapper<TSource> except(Iterable<TSource> second);

	public TSource first();

	public TSource first(Predicate<TSource> predicate);

	public TSource firstOrDefault();

	public TSource firstOrDefault(Predicate<TSource> predicate);

	public void forEach(Consumer<TSource> action);

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> groupJoin(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, Iterable<TInner>, TResult> resultSelector);

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> groupJoin(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, Iterable<TInner>, TResult> resultSelector, Comparator<TKey> comparator);

	public int indexOf(TSource element);

	public IJLinqWrapper<TSource> intersect(Iterable<TSource> second);

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector);

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector, Comparator<TKey> comparator);

	public TSource last();

	public TSource last(Predicate<TSource> predicate);

	public TSource lastOrDefault();

	public TSource lastOrDefault(Predicate<TSource> predicate);

	public long longCount();

	public long longCount(Predicate<TSource> predicate);

	public IJLinqWrapper<Integer> range(int start, int count);

	public IJLinqWrapper<TSource> repeat(TSource element, int count);

	public IJLinqWrapper<TSource> replaceAt(int index, TSource newValue);

	public IJLinqWrapper<TSource> replaceMultiple(TSource newValue, Predicate<TSource> predicate);

	public IJLinqWrapper<TSource> reverse() throws IllegalAccessException;

	public <TResult> IJLinqWrapper<TResult> select(Function<TSource, TResult> selector);

	public <TResult> IJLinqWrapper<TResult> selectMany(Function<TSource, Iterable<TResult>> selector);

	public boolean sequenceEqual(Iterable<TSource> second);

	public boolean sequenceEqual(Iterable<TSource> second, Comparator<TSource> comparator);

	public TSource single();

	public TSource single(Predicate<TSource> predicate);

	public TSource singleOrDefault();

	public TSource singleOrDefault(Predicate<TSource> predicate);

	public IJLinqWrapper<TSource> skip(int count);

	public IJLinqWrapper<TSource> skipWhile(Predicate<TSource> predicate);

	public IJLinqWrapper<TSource> take(int count) throws IllegalAccessException;

	public IJLinqWrapper<TSource> takeWhile(Predicate<TSource> predicate) throws IllegalAccessException;

	public TSource[] toArray() throws IllegalAccessException;

	public List<TSource> toList() throws IllegalAccessException;

	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector) throws IllegalAccessException;

	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector, Comparator<TKey> comparator) throws IllegalAccessException;

	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector) throws IllegalAccessException;

	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector, Comparator<TKey> comparator)
			throws IllegalAccessException;

	public Set<TSource> toSet() throws IllegalAccessException;

	public IJLinqWrapper<TSource> union(Iterable<TSource> second) throws IllegalAccessException;

	public IJLinqWrapper<TSource> where(Predicate<TSource> predicate) throws IllegalAccessException;

	public <TSecond, TResult> IJLinqWrapper<TResult> zip(Iterable<TSecond> second,
			Function2<TSource, TSecond, TResult> resultSelector) throws IllegalAccessException;
}
