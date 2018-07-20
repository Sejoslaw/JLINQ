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
 * Main entry point of JLINQ library. JLINQ operates on {@link Iterable} level
 * which is lower than {@link Collection} level. JLINQ provides all of the basic
 * operations which LINQ does. For simple wrapper of all functionalities of
 * JLINQ see {@link JLinqWrapper}.
 * 
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public final class JLinq {

	private JLinq() {
	}

	public static <TSource> TSource aggregate(Iterable<TSource> source, Function<TSource, TSource> func) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> boolean all(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> boolean any(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> boolean any(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> asIterable(Iterable<TSource> source) {
		List<TSource> iterable = new ArrayList<TSource>();
		source.forEach((element) -> iterable.add(element));
		return iterable;
	}

	// TODO: Add here Average methods

	public static <TSource, TResult> Iterable<TResult> cast(Iterable<TSource> source, Function<TSource, TResult> func) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> concat(Iterable<TSource> first, Iterable<TSource> second) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> boolean contains(Iterable<TSource> source, TSource value) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> boolean contains(Iterable<TSource> source, TSource value, Comparator<TSource> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> int count(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> int count(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> defaultIfEmpty(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> defaultIfEmpty(Iterable<TSource> source, TSource defaultValue) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> distinct(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> distinct(Iterable<TSource> source, Comparator<TSource> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource elementAt(Iterable<TSource> source, int index) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource elementAtOrDefault(Iterable<TSource> source, int index) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> empty() {
		return new ArrayList<TSource>();
	}

	public static <TSource> Iterable<TSource> except(Iterable<TSource> first, Iterable<TSource> second) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> except(Iterable<TSource> first, Iterable<TSource> second,
			Comparator<TSource> comparator) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @param source
	 * @param element
	 * @return Returns all occurrence which fulfill specified selector.
	 */
	public static <TSource> Iterable<TSource> find(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource first(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource first(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource firstOrDefault(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource firstOrDefault(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> void forEach(Iterable<TSource> source, Consumer<TSource> action) {
		if (source == null || action == null) {
			return;
		}

		for (TSource element : source) {
			action.accept(element);
		}
	}

	// TODO: Add here GroupBy methods

	public static <TOuter, TInner, TKey, TResult> Iterable<TResult> groupJoin(Iterable<TOuter> outer,
			Iterable<TInner> inner, Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TOuter, Iterable<TInner>, TResult> resultSelector) {
		throw new UnsupportedOperationException();
	}

	public static <TOuter, TInner, TKey, TResult> Iterable<TResult> groupJoin(Iterable<TOuter> outer,
			Iterable<TInner> inner, Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TOuter, Iterable<TInner>, TResult> resultSelector, Comparator<TKey> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> int indexOf(Iterable<TSource> source, TSource element) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> intersect(Iterable<TSource> first, Iterable<TSource> second) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> intersect(Iterable<TSource> first, Iterable<TSource> second,
			Comparator<TSource> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TOuter, TInner, TKey, TResult> Iterable<TResult> join(Iterable<TOuter> outer, Iterable<TInner> inner,
			Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TOuter, TInner, TResult> resultSelector) {
		throw new UnsupportedOperationException();
	}

	public static <TOuter, TInner, TKey, TResult> Iterable<TResult> join(Iterable<TOuter> outer, Iterable<TInner> inner,
			Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector,
			Function2<TOuter, TInner, TResult> resultSelector, Comparator<TKey> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource last(Iterable<TSource> first) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource last(Iterable<TSource> first, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource lastOrDefault(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource lastOrDefault(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> long longCount(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> long longCount(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	// TODO: Add here Max methods

	// TODO: Add here Min methods

	public static <TSource> Iterable<TSource> ofType(Iterable source) {
		throw new UnsupportedOperationException();
	}

	// TODO: Add here OrderBy and OrderByDescending methods

	public static Iterable<Integer> range(int start, int count) {
		throw new UnsupportedOperationException();
	}

	public static <TResult> Iterable<TResult> repeat(TResult element, int count) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> replaceAt(Iterable<TSource> source, int index, TSource newValue) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @param source
	 * @param newValue
	 * @param predicate
	 * @return Replaces all occurrence which fulfil the predicate with new specified
	 *         value.
	 */
	public static <TSource> Iterable<TSource> replaceMultiple(Iterable<TSource> source, TSource newValue,
			Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> reverse(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TResult> Iterable<TResult> select(Iterable<TSource> source,
			Function<TSource, TResult> selector) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TResult> Iterable<TResult> select(Iterable<TSource> source,
			Function2<TSource, Integer, TResult> selector) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TResult> Iterable<TResult> selectMany(Iterable<TSource> source,
			Function<TSource, Iterable<TResult>> selector) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TCollection, TResult> Iterable<TResult> selectMany(Iterable<TSource> source,
			Function<TSource, Iterable<TCollection>> collectionSelector,
			Function2<TSource, TCollection, TResult> resultSelector) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TCollection, TResult> Iterable<TResult> selectMany(Iterable<TSource> source,
			Function2<TSource, Integer, Iterable<TCollection>> collectionSelector,
			Function2<TSource, TCollection, TResult> resultSelector) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TResult> Iterable<TResult> selectMany(Iterable<TSource> source,
			Function2<TSource, Integer, Iterable<TResult>> selector) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> boolean sequenceEqual(Iterable<TSource> first, Iterable<TSource> second) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> boolean sequenceEqual(Iterable<TSource> first, Iterable<TSource> second,
			Comparator<TSource> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource single(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource single(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource singleOrDefault(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> TSource singleOrDefault(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> skip(Iterable<TSource> source, int count) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> skipWhile(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> skipWhile(Iterable<TSource> source,
			Function2<TSource, Integer, Boolean> predicate) {
		throw new UnsupportedOperationException();
	}

	// TODO: Add here Sum methods

	public static <TSource> Iterable<TSource> take(Iterable<TSource> source, int count) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> takeWhile(Iterable<TSource> source, Predicate<TSource> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> takeWhile(Iterable<TSource> source,
			Function2<TSource, Integer, Boolean> predicate) {
		throw new UnsupportedOperationException();
	}

	// TODO: Add here ThenBy and ThenByDescending methods

	public static <TSource> TSource[] toArray(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> List<TSource> toList(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TKey, TElement> Map<TKey, TElement> toMap(Iterable<TSource> source,
			Function<TSource, TKey> keySelector, Function<TSource, TElement> elementSelector) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TKey, TElement> Map<TKey, TElement> toMap(Iterable<TSource> source,
			Function<TSource, TKey> keySelector, Function<TSource, TElement> elementSelector,
			Comparator<TKey> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TKey> Map<TKey, TSource> toMap(Iterable<TSource> source,
			Function<TSource, TKey> keySelector) {
		throw new UnsupportedOperationException();
	}

	public static <TSource, TKey> Map<TKey, TSource> toMap(Iterable<TSource> source,
			Function<TSource, TKey> keySelector, Comparator<TKey> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Set<TSource> toSet(Iterable<TSource> source) {
		throw new UnsupportedOperationException();
	}

	// TODO: Add here ToLookup methods

	public static <TSource> Iterable<TSource> union(Iterable<TSource> first, Iterable<TSource> second) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> union(Iterable<TSource> first, Iterable<TSource> second,
			Comparator<TSource> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> where(Iterable<TSource> source, Predicate<TSource> predicate) {
		if (source == null || predicate == null) {
			return null;
		}

		return new WhereIterator<TSource>(source, predicate);
	}

	public static <TSource> Iterable<TSource> where(Iterable<TSource> source,
			Function2<TSource, Integer, Boolean> predicate) {
		throw new UnsupportedOperationException();
	}

	public static <TFirst, TSecond, TResult> Iterable<TResult> zip(Iterable<TFirst> first, Iterable<TSecond> second,
			Function2<TFirst, TSecond, TResult> resultSelector) {
		throw new UnsupportedOperationException();
	}
}
