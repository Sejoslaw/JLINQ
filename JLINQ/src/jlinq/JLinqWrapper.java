package jlinq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.functions.Function2;

/**
 * Wraps functionality of JLINQ to allow for faster method calls. Generic
 * parameter is a parameter of initial {@link Iterable} passed in argument. Use
 * it as a standard .NET IEnumerable: MyList.Where(...).Select(...).ToList();
 * The only requirement is to give JLinqWrapper an {@link Iterable} on which you
 * want to operate. Internal {@link Iterable} is always use as a first
 * parameters in JLinq methods.
 * 
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public final class JLinqWrapper<TSource> {

	private Iterable<TSource> iterable;

	public JLinqWrapper() {
		this.iterable = new ArrayList<TSource>();
	}

	public JLinqWrapper(Iterable<TSource> iterable) {
		this.iterable = iterable;
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

	public JLinqWrapper<TSource> asIterable() {
		return new JLinqWrapper<TSource>(JLinq.asIterable(this.iterable));
	}

	// TODO: Add here Average methods

	public <TResult> JLinqWrapper<TResult> cast(Function<TSource, TResult> func) {
		return new JLinqWrapper<TResult>(JLinq.cast(this.iterable, func));
	}

	public JLinqWrapper<TSource> concat(Iterable<TSource> second) {
		return new JLinqWrapper<TSource>(JLinq.concat(this.iterable, second));
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

	public JLinqWrapper<TSource> defaultIfEmpty() {
		return new JLinqWrapper<TSource>(JLinq.defaultIfEmpty(this.iterable));
	}

	public JLinqWrapper<TSource> defaultIfEmpty(TSource defaultValue) {
		return new JLinqWrapper<TSource>(JLinq.defaultIfEmpty(this.iterable, defaultValue));
	}

	public JLinqWrapper<TSource> distinct() {
		return new JLinqWrapper<TSource>(JLinq.distinct(this.iterable));
	}

	public JLinqWrapper<TSource> distinct(Comparator<TSource> comparator) {
		return new JLinqWrapper<TSource>(JLinq.distinct(this.iterable, comparator));
	}

	public TSource elementAt(int index) {
		return JLinq.elementAt(this.iterable, index);
	}

	public TSource elementAtOrDefault(int index) {
		return JLinq.elementAtOrDefault(this.iterable, index);
	}

	public JLinqWrapper<TSource> empty() {
		return new JLinqWrapper<TSource>(JLinq.empty());
	}

	public JLinqWrapper<TSource> except(Iterable<TSource> second) {
		return new JLinqWrapper<TSource>(JLinq.except(this.iterable, second));
	}

	public JLinqWrapper<TSource> except(Iterable<TSource> second, Comparator<TSource> comparator) {
		return new JLinqWrapper<TSource>(JLinq.except(this.iterable, second, comparator));
	}

	public JLinqWrapper<TSource> find(Predicate<TSource> predicate) {
		return new JLinqWrapper<TSource>(JLinq.find(this.iterable, predicate));
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

	public void forEach(Consumer<TSource> action) {
		JLinq.forEach(this.iterable, action);
	}

	// TODO: Add here GroupBy methods

	public <TInner, TKey, TResult> JLinqWrapper<TResult> groupJoin(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, Iterable<TInner>, TResult> resultSelector) {
		return new JLinqWrapper<TResult>(
				JLinq.groupJoin(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector));
	}

	public <TInner, TKey, TResult> JLinqWrapper<TResult> groupJoin(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, Iterable<TInner>, TResult> resultSelector, Comparator<TKey> comparator) {
		return new JLinqWrapper<TResult>(
				JLinq.groupJoin(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector, comparator));
	}

	public int indexOf(TSource element) {
		return JLinq.indexOf(this.iterable, element);
	}

	public JLinqWrapper<TSource> intersect(Iterable<TSource> second) {
		return new JLinqWrapper<TSource>(JLinq.intersect(this.iterable, second));
	}

	public JLinqWrapper<TSource> intersect(Iterable<TSource> second, Comparator<TSource> comparator) {
		return new JLinqWrapper<TSource>(JLinq.intersect(this.iterable, second, comparator));
	}

	public <TInner, TKey, TResult> JLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector) {
		return new JLinqWrapper<TResult>(
				JLinq.join(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector));
	}

	public <TInner, TKey, TResult> JLinqWrapper<TResult> join(Iterable<TInner> inner,
			Function<TSource, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TSource, TInner, TResult> resultSelector, Comparator<TKey> comparator) {
		return new JLinqWrapper<TResult>(
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

	// TODO: Add here Max methods

	// TODO: Add here Min methods

	public JLinqWrapper<TSource> ofType() {
		return new JLinqWrapper<TSource>(JLinq.ofType(this.iterable));
	}

	// TODO: Add here OrderBy and OrderByDescending methods

	public JLinqWrapper<Integer> range(int start, int count) {
		return new JLinqWrapper<Integer>(JLinq.range(start, count));
	}

	public JLinqWrapper<TSource> repeat(TSource element, int count) {
		return new JLinqWrapper<TSource>(JLinq.repeat(element, count));
	}

	public JLinqWrapper<TSource> replaceAt(int index, TSource newValue) {
		return new JLinqWrapper<TSource>(JLinq.replaceAt(this.iterable, index, newValue));
	}

	public JLinqWrapper<TSource> replaceMultiple(TSource newValue, Predicate<TSource> predicate) {
		return new JLinqWrapper<TSource>(JLinq.replaceMultiple(this.iterable, newValue, predicate));
	}

	public JLinqWrapper<TSource> reverse() {
		return new JLinqWrapper<TSource>(JLinq.reverse(this.iterable));
	}

	public <TResult> JLinqWrapper<TResult> select(Function<TSource, TResult> selector) {
		return new JLinqWrapper<TResult>(JLinq.select(this.iterable, selector));
	}

	public <TResult> JLinqWrapper<TResult> select(Function2<TSource, Integer, TResult> selector) {
		return new JLinqWrapper<TResult>(JLinq.select(this.iterable, selector));
	}

	public <TResult> JLinqWrapper<TResult> selectMany(Function<TSource, Iterable<TResult>> selector) {
		return new JLinqWrapper<TResult>(JLinq.selectMany(this.iterable, selector));
	}

	public <TCollection, TResult> JLinqWrapper<TResult> selectMany(
			Function<TSource, Iterable<TCollection>> collectionSelector,
			Function2<TSource, TCollection, TResult> resultSelector) {
		return new JLinqWrapper<TResult>(JLinq.selectMany(this.iterable, collectionSelector, resultSelector));
	}

	public <TCollection, TResult> JLinqWrapper<TResult> selectMany(
			Function2<TSource, Integer, Iterable<TCollection>> collectionSelector,
			Function2<TSource, TCollection, TResult> resultSelector) {
		return new JLinqWrapper<TResult>(JLinq.selectMany(this.iterable, collectionSelector, resultSelector));
	}

	public <TResult> JLinqWrapper<TResult> selectMany(Function2<TSource, Integer, Iterable<TResult>> selector) {
		return new JLinqWrapper<TResult>(JLinq.selectMany(this.iterable, selector));
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

	public JLinqWrapper<TSource> skip(int count) {
		return new JLinqWrapper<TSource>(JLinq.skip(this.iterable, count));
	}

	public JLinqWrapper<TSource> skipWhile(Predicate<TSource> predicate) {
		return new JLinqWrapper<TSource>(JLinq.skipWhile(this.iterable, predicate));
	}

	// TODO: Add here Sum methods

	public JLinqWrapper<TSource> take(int count) throws IllegalAccessException {
		return new JLinqWrapper<TSource>(JLinq.take(this.iterable, count));
	}

	public JLinqWrapper<TSource> takeWhile(Predicate<TSource> predicate) throws IllegalAccessException {
		return new JLinqWrapper<TSource>(JLinq.takeWhile(this.iterable, predicate));
	}

	// TODO: Add here ThenBy and ThenByDescending methods

	public TSource[] toArray() throws IllegalAccessException {
		return JLinq.toArray(this.iterable);
	}

	public List<TSource> toList() throws IllegalAccessException {
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

	public JLinqWrapper<TSource> union(Iterable<TSource> second) {
		return new JLinqWrapper<TSource>(JLinq.union(this.iterable, second));
	}

	public JLinqWrapper<TSource> union(Iterable<TSource> second, Comparator<TSource> comparator) {
		return new JLinqWrapper<TSource>(JLinq.union(this.iterable, second, comparator));
	}

	public JLinqWrapper<TSource> where(Predicate<TSource> predicate) throws IllegalAccessException {
		return new JLinqWrapper<TSource>(JLinq.where(this.iterable, predicate));
	}

	public <TSecond, TResult> JLinqWrapper<TResult> zip(Iterable<TSecond> second,
			Function2<TSource, TSecond, TResult> resultSelector) throws IllegalAccessException {
		return new JLinqWrapper<TResult>(JLinq.zip(this.iterable, second, resultSelector));
	}
}