package jlinq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jlinq.functions.Function2;
import jlinq.interfaces.IJLinqWrapper;
import jlinq.interfaces.INumberJLinqWrapper;
import jlinq.interfaces.IParallelJLinqWrapper;
import jlinq.parallel.IParallelQueryOptions;

/**
 * Wraps functionality of JLINQ to allow for faster method calls. Generic
 * parameter is a parameter of initial {@link Iterable} passed in argument. Use
 * it as a standard .NET IEnumerable: MyList.Where(...).Select(...).ToList();
 * The only requirement is to give JLinqWrapper an {@link Iterable} on which you
 * want to operate. Internal {@link Iterable} is always use as a first
 * parameters in JLinq methods. For more detailed information about the methods,
 * please see: {@link IJLinqWrapper}.
 * 
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TSource>
 */
public class JLinqWrapper<TSource> implements IJLinqWrapper<TSource> {

	/**
	 * Source collection.
	 */
	protected Iterable<TSource> iterable;

	public JLinqWrapper() {
		this.iterable = new ArrayList<>();
	}

	public JLinqWrapper(Iterable<TSource> iterable) {
		this.iterable = iterable;
	}

	public JLinqWrapper(Stream<TSource> stream) {
		this.iterable = stream.collect(Collectors.toList());
	}

	public TSource aggregate(Function2<TSource, TSource, TSource> func) {
		return JLinq.aggregate(this.iterable, func);
	}

	public boolean all(Predicate<TSource> predicate) {
		return JLinq.all(this.iterable, predicate);
	}

	public boolean any() {
		return JLinq.any(this.iterable);
	}

	public boolean any(Predicate<TSource> predicate) {
		return JLinq.any(this.iterable, predicate);
	}

	public IJLinqWrapper<TSource> asIterable() {
		return this;
	}

	public <TNumber extends Number & Comparable<TNumber>> INumberJLinqWrapper<TNumber> asNumbered(
			Function<TSource, TNumber> func) throws IllegalAccessException {
		IJLinqWrapper<TNumber> numbers = this.cast(func);
		List<TNumber> numbersList = numbers.toList();
		return new NumberJLinqWrapper<>(numbersList);
	}

	public IParallelJLinqWrapper<TSource> asParallel(IParallelQueryOptions options) throws IllegalAccessException {
		return new ParallelJLinqWrapper<>(this, options, true);
	}

	public <TResult> IJLinqWrapper<TResult> cast(Function<TSource, TResult> func) {
		return new JLinqWrapper<>(JLinq.cast(this.iterable, func));
	}

	public IJLinqWrapper<TSource> concat(Iterable<TSource> second) {
		return new JLinqWrapper<>(JLinq.concat(this.iterable, second));
	}

	public boolean contains(TSource value) {
		return JLinq.contains(this.iterable, value);
	}

	public boolean contains(TSource value, Comparator<TSource> comparator) {
		return JLinq.contains(this.iterable, value, comparator);
	}

	public int count() {
		return JLinq.count(this.iterable);
	}

	public int count(Predicate<TSource> predicate) {
		return JLinq.count(this.iterable, predicate);
	}

	public IJLinqWrapper<TSource> defaultIfEmpty() {
		return new JLinqWrapper<>(JLinq.defaultIfEmpty(this.iterable));
	}

	public IJLinqWrapper<TSource> defaultIfEmpty(TSource defaultValue) {
		return new JLinqWrapper<>(JLinq.defaultIfEmpty(this.iterable, defaultValue));
	}

	public IJLinqWrapper<TSource> distinct() {
		return new JLinqWrapper<>(JLinq.distinct(this.iterable));
	}

	public TSource elementAt(int index) {
		return JLinq.elementAt(this.iterable, index);
	}

	public TSource elementAtOrDefault(int index) {
		return JLinq.elementAtOrDefault(this.iterable, index);
	}

	public IJLinqWrapper<TSource> empty() {
		return new JLinqWrapper<>(JLinq.empty());
	}

	public IJLinqWrapper<TSource> except(Iterable<TSource> second) {
		return new JLinqWrapper<>(JLinq.except(this.iterable, second));
	}

	public TSource first() {
		return JLinq.first(this.iterable);
	}

	public TSource first(Predicate<TSource> predicate) {
		return JLinq.first(this.iterable, predicate);
	}

	public TSource firstOrDefault() {
		return JLinq.firstOrDefault(this.iterable);
	}

	public TSource firstOrDefault(Predicate<TSource> predicate) {
		return JLinq.firstOrDefault(this.iterable, predicate);
	}

	// TODO: Add here GroupBy methods

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> groupJoin(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, Iterable<TInner>, TResult> resultSelector) {
		return new JLinqWrapper<>(
				JLinq.groupJoin(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector));
	}

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> groupJoin(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, Iterable<TInner>, TResult> resultSelector, Comparator<TKey> comparator) {
		return new JLinqWrapper<>(
				JLinq.groupJoin(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector, comparator));
	}

	public int indexOf(TSource element) {
		return JLinq.indexOf(this.iterable, element);
	}

	public IJLinqWrapper<TSource> intersect(Iterable<TSource> second) {
		return new JLinqWrapper<>(JLinq.intersect(this.iterable, second));
	}

	public Iterator<TSource> iterator() {
		return this.iterable.iterator();
	}

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector) {
		return new JLinqWrapper<>(JLinq.join(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector));
	}

	public <TInner, TKey, TResult> IJLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector, Comparator<TKey> comparator) {
		return new JLinqWrapper<>(
				JLinq.join(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector, comparator));
	}

	public TSource last() {
		return JLinq.last(this.iterable);
	}

	public TSource last(Predicate<TSource> predicate) {
		return JLinq.last(this.iterable, predicate);
	}

	public TSource lastOrDefault() {
		return JLinq.last(this.iterable);
	}

	public TSource lastOrDefault(Predicate<TSource> predicate) {
		return JLinq.last(this.iterable, predicate);
	}

	public long longCount() {
		return JLinq.longCount(this.iterable);
	}

	public long longCount(Predicate<TSource> predicate) {
		return JLinq.longCount(this.iterable, predicate);
	}

	public <TKey extends Comparable<TKey>> IJLinqWrapper<TSource> orderBy(Function<TSource, TKey> keySelector) {
		return new JLinqWrapper<>(JLinq.orderBy(this.iterable, keySelector, false));
	}

	public <TKey extends Comparable<TKey>> IJLinqWrapper<TSource> orderByDescending(
			Function<TSource, TKey> keySelector) {
		return new JLinqWrapper<>(JLinq.orderBy(this.iterable, keySelector, true));
	}

	public IJLinqWrapper<Integer> range(int start, int count) {
		return new JLinqWrapper<>(JLinq.range(start, count));
	}

	public IJLinqWrapper<TSource> repeat(TSource element, int count) {
		return new JLinqWrapper<>(JLinq.repeat(element, count));
	}

	public IJLinqWrapper<TSource> replaceAt(int index, TSource newValue) {
		return new JLinqWrapper<>(JLinq.replaceAt(this.iterable, index, newValue));
	}

	public IJLinqWrapper<TSource> replaceMultiple(TSource newValue, Predicate<TSource> predicate) {
		return new JLinqWrapper<>(JLinq.replaceMultiple(this.iterable, newValue, predicate));
	}

	public IJLinqWrapper<TSource> reverse() throws IllegalAccessException {
		return new JLinqWrapper<>(JLinq.reverse(this.iterable));
	}

	public <TResult> IJLinqWrapper<TResult> select(Function<TSource, TResult> selector) {
		return new JLinqWrapper<>(JLinq.select(this.iterable, selector));
	}

	public <TResult> IJLinqWrapper<TResult> selectMany(Function<TSource, Iterable<TResult>> selector) {
		return new JLinqWrapper<>(JLinq.selectMany(this.iterable, selector));
	}

	public boolean sequenceEqual(Iterable<TSource> second) {
		return JLinq.sequenceEqual(this.iterable, second);
	}

	public boolean sequenceEqual(Iterable<TSource> second, Comparator<TSource> comparator) {
		return JLinq.sequenceEqual(this.iterable, second, comparator);
	}

	public TSource single() {
		return JLinq.single(this.iterable);
	}

	public TSource single(Predicate<TSource> predicate) {
		return JLinq.single(this.iterable, predicate);
	}

	public TSource singleOrDefault() {
		return JLinq.singleOrDefault(this.iterable);
	}

	public TSource singleOrDefault(Predicate<TSource> predicate) {
		return JLinq.singleOrDefault(this.iterable, predicate);
	}

	public IJLinqWrapper<TSource> skip(int count) {
		return new JLinqWrapper<>(JLinq.skip(this.iterable, count));
	}

	public IJLinqWrapper<TSource> skipWhile(Predicate<TSource> predicate) {
		return new JLinqWrapper<>(JLinq.skipWhile(this.iterable, predicate));
	}

	public IJLinqWrapper<TSource> take(int count) throws IllegalAccessException {
		return new JLinqWrapper<>(JLinq.take(this.iterable, count));
	}

	public IJLinqWrapper<TSource> takeWhile(Predicate<TSource> predicate) throws IllegalAccessException {
		return new JLinqWrapper<>(JLinq.takeWhile(this.iterable, predicate));
	}

	// TODO: Add here ThenBy and ThenByDescending methods

	public TSource[] toArray() throws IllegalAccessException {
		return JLinq.toArray(this.iterable);
	}

	public List<TSource> toList() {
		return JLinq.toList(this.iterable);
	}

	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector) throws IllegalAccessException {
		return JLinq.toMap(this.iterable, keySelector, elementSelector);
	}

	public <TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector, Comparator<TKey> comparator) throws IllegalAccessException {
		return JLinq.toMap(this.iterable, keySelector, elementSelector, comparator);
	}

	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector) throws IllegalAccessException {
		return JLinq.toMap(this.iterable, keySelector);
	}

	public <TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector, Comparator<TKey> comparator)
			throws IllegalAccessException {
		return JLinq.toMap(this.iterable, keySelector, comparator);
	}

	public Set<TSource> toSet() throws IllegalAccessException {
		return JLinq.toSet(this.iterable);
	}

	// TODO: Add here ToLookup methods

	public IJLinqWrapper<TSource> union(Iterable<TSource> second) throws IllegalAccessException {
		return new JLinqWrapper<>(JLinq.union(this.iterable, second));
	}

	public IJLinqWrapper<TSource> where(Predicate<TSource> predicate) throws IllegalAccessException {
		return new JLinqWrapper<>(JLinq.where(this.iterable, predicate));
	}

	public <TSecond, TResult> IJLinqWrapper<TResult> zip(Iterable<TSecond> second,
			Function2<TSource, TSecond, TResult> resultSelector) throws IllegalAccessException {
		return new JLinqWrapper<>(JLinq.zip(this.iterable, second, resultSelector));
	}
}
