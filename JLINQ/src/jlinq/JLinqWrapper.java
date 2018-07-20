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
 * Wraps functionality of JLINQ to allow for faster method calls. Use it as a
 * standard .NET IEnumerable: MyList.Where(...).Select(...).ToList(); The only
 * requirement is to give JLinqWrapper an {@link Iterable} on which you want to
 * operate. Internal {@link Iterable} is always use as a first parameters in
 * JLinq methods.
 * 
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public final class JLinqWrapper {

	@SuppressWarnings("rawtypes")
	private Iterable iterable;

	@SuppressWarnings("rawtypes")
	public JLinqWrapper() {
		this.iterable = new ArrayList();
	}

	@SuppressWarnings("rawtypes")
	public JLinqWrapper(Iterable iterable) {
		this.iterable = iterable;
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource aggregate(Function<TSource, TSource> func) {
		return (TSource) JLinq.aggregate(this.iterable, func);
	}

	@SuppressWarnings("unchecked")
	public <TSource> boolean all(Predicate<TSource> predicate) {
		return JLinq.all(this.iterable, predicate);
	}

	@SuppressWarnings("unchecked")
	public <TSource> boolean any() {
		return JLinq.any(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> boolean any(Predicate<TSource> predicate) {
		return JLinq.any(this.iterable, predicate);
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper asIterable() {
		this.iterable = JLinq.asIterable(this.iterable);
		return this;
	}

	// TODO: Add here Average methods

	@SuppressWarnings("unchecked")
	public <TSource, TResult> JLinqWrapper cast(Function<TSource, TResult> func) {
		this.iterable = JLinq.cast(this.iterable, func);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper concat(Iterable<TSource> second) {
		this.iterable = JLinq.concat(this.iterable, second);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> boolean contains(TSource value) {
		return JLinq.contains(this.iterable, value);
	}

	@SuppressWarnings("unchecked")
	public <TSource> boolean contains(TSource value, Comparator<TSource> comparator) {
		return JLinq.contains(this.iterable, value, comparator);
	}

	@SuppressWarnings("unchecked")
	public <TSource> int count() {
		return JLinq.count(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> int count(Predicate<TSource> predicate) {
		return JLinq.count(this.iterable, predicate);
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper defaultIfEmpty() {
		this.iterable = JLinq.defaultIfEmpty(this.iterable);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper defaultIfEmpty(TSource defaultValue) {
		this.iterable = JLinq.defaultIfEmpty(this.iterable, defaultValue);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper distinct() {
		this.iterable = JLinq.distinct(this.iterable);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper distinct(Comparator<TSource> comparator) {
		this.iterable = JLinq.distinct(this.iterable, comparator);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource elementAt(int index) {
		return (TSource) JLinq.elementAt(this.iterable, index);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource elementAtOrDefault(int index) {
		return (TSource) JLinq.elementAtOrDefault(this.iterable, index);
	}

	public JLinqWrapper empty() {
		this.iterable = JLinq.empty();
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper except(Iterable<TSource> second) {
		this.iterable = JLinq.except(this.iterable, second);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper except(Iterable<TSource> second, Comparator<TSource> comparator) {
		this.iterable = JLinq.except(this.iterable, second, comparator);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper find(Predicate<TSource> predicate) {
		this.iterable = JLinq.find(this.iterable, predicate);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource first() {
		return (TSource) JLinq.first(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource first(Predicate<TSource> predicate) {
		return (TSource) JLinq.first(this.iterable, predicate);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource firstOrDefault() {
		return (TSource) JLinq.firstOrDefault(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource firstOrDefault(Predicate<TSource> predicate) {
		return (TSource) JLinq.firstOrDefault(this.iterable, predicate);
	}

	@SuppressWarnings("unchecked")
	public <TSource> void forEach(Consumer<TSource> action) {
		JLinq.forEach(this.iterable, action);
	}

	// TODO: Add here GroupBy methods

	@SuppressWarnings("unchecked")
	public <TOuter, TInner, TKey, TResult> JLinqWrapper groupJoin(Iterable<TInner> inner,
			Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TOuter, Iterable<TInner>, TResult> resultSelector) {
		this.iterable = JLinq.groupJoin(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TOuter, TInner, TKey, TResult> JLinqWrapper groupJoin(Iterable<TInner> inner,
			Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TOuter, Iterable<TInner>, TResult> resultSelector, Comparator<TKey> comparator) {
		this.iterable = JLinq.groupJoin(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector,
				comparator);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> int indexOf(TSource element) {
		return JLinq.indexOf(this.iterable, element);
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper intersect(Iterable<TSource> second) {
		this.iterable = JLinq.intersect(this.iterable, second);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper intersect(Iterable<TSource> second, Comparator<TSource> comparator) {
		this.iterable = JLinq.intersect(this.iterable, second, comparator);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TOuter, TInner, TKey, TResult> JLinqWrapper join(Iterable<TInner> inner,
			Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TOuter, TInner, TResult> resultSelector) {
		this.iterable = JLinq.join(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TOuter, TInner, TKey, TResult> JLinqWrapper join(Iterable<TInner> inner,
			Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TOuter, TInner, TResult> resultSelector, Comparator<TKey> comparator) {
		this.iterable = JLinq.join(this.iterable, inner, outerKeySelector, innerKeySelector, resultSelector,
				comparator);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource last() {
		return (TSource) JLinq.last(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource last(Predicate<TSource> predicate) {
		return (TSource) JLinq.last(this.iterable, predicate);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource lastOrDefault() {
		return (TSource) JLinq.last(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource lastOrDefault(Predicate<TSource> predicate) {
		return (TSource) JLinq.last(this.iterable, predicate);
	}

	@SuppressWarnings("unchecked")
	public <TSource> long longCount() {
		return JLinq.longCount(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> long longCount(Predicate<TSource> predicate) {
		return JLinq.longCount(this.iterable, predicate);
	}

	// TODO: Add here Max methods

	// TODO: Add here Min methods

	public <TSource> JLinqWrapper ofType() {
		this.iterable = JLinq.ofType(this.iterable);
		return this;
	}

	// TODO: Add here OrderBy and OrderByDescending methods

	public JLinqWrapper range(int start, int count) {
		this.iterable = JLinq.range(start, count);
		return this;
	}

	public <TResult> JLinqWrapper repeat(TResult element, int count) {
		this.iterable = JLinq.repeat(element, count);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper replaceAt(int index, TSource newValue) {
		this.iterable = JLinq.replaceAt(this.iterable, index, newValue);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper replaceMultiple(TSource newValue, Predicate<TSource> predicate) {
		this.iterable = JLinq.replaceMultiple(this.iterable, newValue, predicate);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper reverse() {
		this.iterable = JLinq.reverse(this.iterable);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource, TResult> JLinqWrapper select(Function<TSource, TResult> selector) {
		this.iterable = JLinq.select(this.iterable, selector);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource, TResult> JLinqWrapper select(Function2<TSource, Integer, TResult> selector) {
		this.iterable = JLinq.select(this.iterable, selector);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource, TResult> JLinqWrapper selectMany(Function<TSource, Iterable<TResult>> selector) {
		this.iterable = JLinq.selectMany(this.iterable, selector);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource, TCollection, TResult> JLinqWrapper selectMany(
			Function<TSource, Iterable<TCollection>> collectionSelector,
			Function2<TSource, TCollection, TResult> resultSelector) {
		this.iterable = JLinq.selectMany(this.iterable, collectionSelector, resultSelector);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource, TCollection, TResult> JLinqWrapper selectMany(
			Function2<TSource, Integer, Iterable<TCollection>> collectionSelector,
			Function2<TSource, TCollection, TResult> resultSelector) {
		this.iterable = JLinq.selectMany(this.iterable, collectionSelector, resultSelector);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource, TResult> JLinqWrapper selectMany(Function2<TSource, Integer, Iterable<TResult>> selector) {
		this.iterable = JLinq.selectMany(this.iterable, selector);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> boolean sequenceEqual(Iterable<TSource> second) {
		return JLinq.sequenceEqual(this.iterable, second);
	}

	@SuppressWarnings("unchecked")
	public <TSource> boolean sequenceEqual(Iterable<TSource> second, Comparator<TSource> comparator) {
		return JLinq.sequenceEqual(this.iterable, second, comparator);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource single() {
		return (TSource) JLinq.single(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource single(Predicate<TSource> predicate) {
		return (TSource) JLinq.single(this.iterable, predicate);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource singleOrDefault() {
		return (TSource) JLinq.singleOrDefault(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> TSource singleOrDefault(Predicate<TSource> predicate) {
		return (TSource) JLinq.singleOrDefault(this.iterable, predicate);
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper skip(int count) {
		this.iterable = JLinq.skip(this.iterable, count);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper skipWhile(Predicate<TSource> predicate) {
		this.iterable = JLinq.skipWhile(this.iterable, predicate);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper skipWhile(Function2<TSource, Integer, Boolean> predicate) {
		this.iterable = JLinq.skipWhile(this.iterable, predicate);
		return this;
	}

	// TODO: Add here Sum methods

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper take(int count) {
		this.iterable = JLinq.take(this.iterable, count);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper takeWhile(Predicate<TSource> predicate) {
		this.iterable = JLinq.takeWhile(this.iterable, predicate);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper takeWhile(Function2<TSource, Integer, Boolean> predicate) {
		this.iterable = JLinq.takeWhile(this.iterable, predicate);
		return this;
	}

	// TODO: Add here ThenBy and ThenByDescending methods

	@SuppressWarnings("unchecked")
	public <TSource> TSource[] toArray() {
		return (TSource[]) JLinq.toArray(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource> List<TSource> toList() {
		return JLinq.toList(this.iterable);
	}

	@SuppressWarnings("unchecked")
	public <TSource, TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector) {
		return JLinq.toMap(this.iterable, keySelector, elementSelector);
	}

	@SuppressWarnings("unchecked")
	public <TSource, TKey, TElement> Map<TKey, TElement> toMap(Function<TSource, TKey> keySelector,
			Function<TSource, TElement> elementSelector, Comparator<TKey> comparator) {
		return JLinq.toMap(this.iterable, keySelector, elementSelector, comparator);
	}

	@SuppressWarnings("unchecked")
	public <TSource, TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector) {
		return JLinq.toMap(this.iterable, keySelector);
	}

	@SuppressWarnings("unchecked")
	public <TSource, TKey> Map<TKey, TSource> toMap(Function<TSource, TKey> keySelector, Comparator<TKey> comparator) {
		return JLinq.toMap(this.iterable, keySelector, comparator);
	}

	@SuppressWarnings("unchecked")
	public <TSource> Set<TSource> toSet() {
		return JLinq.toSet(this.iterable);
	}

	// TODO: Add here ToLookup methods

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper union(Iterable<TSource> second) {
		this.iterable = JLinq.union(this.iterable, second);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper union(Iterable<TSource> second, Comparator<TSource> comparator) {
		this.iterable = JLinq.union(this.iterable, second, comparator);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper where(Predicate<TSource> predicate) {
		this.iterable = JLinq.where(this.iterable, predicate);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TSource> JLinqWrapper where(Function2<TSource, Integer, Boolean> predicate) {
		this.iterable = JLinq.where(this.iterable, predicate);
		return this;
	}

	@SuppressWarnings("unchecked")
	public <TFirst, TSecond, TResult> JLinqWrapper zip(Iterable<TSecond> second,
			Function2<TFirst, TSecond, TResult> resultSelector) {
		this.iterable = JLinq.zip(this.iterable, second, resultSelector);
		return this;
	}
}
