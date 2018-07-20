package jlinq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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

	public static <TSource> TSource aggregate(Iterable<TSource> source, Function2<TSource, TSource, TSource> func) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (func == null)
			throw new IllegalArgumentException("func is null");

		TSource result = null;
		for (TSource element : source) {
			result = func.apply(result, element);
		}

		return result;
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
		if (source == null)
			throw new IllegalArgumentException("source is null");

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
		if (source == null)
			throw new IllegalArgumentException("source is null");

		int count = 0;
		for (TSource element : source)
			count++;

		return count;
	}

	public static <TSource> int count(Iterable<TSource> source, Predicate<TSource> predicate) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (predicate == null)
			throw new IllegalArgumentException("predicate is null");

		int count = 0;
		for (TSource element : source)
			if (predicate.test(element))
				count++;

		return count;
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
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (action == null)
			throw new IllegalArgumentException("action is null");

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

	// TODO: Add here Sum methods

	public static <TSource> Iterable<TSource> take(Iterable<TSource> source, int count) throws IllegalAccessException {
		if (source == null)
			throw new IllegalAccessException("source is null");
		if (count < 0)
			throw new IllegalAccessException("count must be a positive value");

		return new TakeIterator<TSource>(source, count);
	}

	public static <TSource> Iterable<TSource> takeWhile(Iterable<TSource> source, Predicate<TSource> predicate)
			throws IllegalAccessException {
		if (source == null)
			throw new IllegalAccessException("source is null");
		if (predicate == null)
			throw new IllegalAccessException("predicate is null");

		return new TakeWhileIterator<TSource>(source, predicate);
	}

	// TODO: Add here ThenBy and ThenByDescending methods

	@SuppressWarnings("unchecked")
	public static <TSource> TSource[] toArray(Iterable<TSource> source) throws IllegalAccessException {
		if (source == null)
			throw new IllegalAccessException("source is null");

		int count = JLinq.count(source);
		Object[] array = new Object[count];

		int index = 0;
		for (TSource element : source) {
			array[index] = element;
			index++;
		}

		return (TSource[]) array;
	}

	public static <TSource> List<TSource> toList(Iterable<TSource> source) throws IllegalAccessException {
		if (source == null)
			throw new IllegalAccessException("source is null");

		List<TSource> list = new ArrayList<TSource>();
		for (TSource element : source)
			list.add(element);

		return list;
	}

	public static <TSource, TKey, TElement> Map<TKey, TElement> toMap(Iterable<TSource> source,
			Function<TSource, TKey> keySelector, Function<TSource, TElement> elementSelector)
			throws IllegalAccessException {
		if (source == null)
			throw new IllegalAccessException("source is null");
		if (keySelector == null)
			throw new IllegalAccessException("keySelector is null");
		if (elementSelector == null)
			throw new IllegalAccessException("elementSelector is null");

		Map<TKey, TElement> map = new HashMap<TKey, TElement>();
		for (TSource element : source) {
			TKey key = keySelector.apply(element);
			TElement value = elementSelector.apply(element);
			map.put(key, value);
		}

		return map;
	}

	public static <TSource, TKey, TElement> Map<TKey, TElement> toMap(Iterable<TSource> source,
			Function<TSource, TKey> keySelector, Function<TSource, TElement> elementSelector,
			Comparator<TKey> comparator) throws IllegalAccessException {

		if (source == null)
			throw new IllegalAccessException("source is null");
		if (keySelector == null)
			throw new IllegalAccessException("keySelector is null");
		if (elementSelector == null)
			throw new IllegalAccessException("elementSelector is null");

		Map<TKey, TElement> map = new HashMap<TKey, TElement>();
		for (TSource element : source) {
			TKey key = keySelector.apply(element);
			TElement value = elementSelector.apply(element);

			for (TKey mappedKey : map.keySet()) {
				if (comparator.compare(key, mappedKey) > 0) {
					map.put(key, value);
				}
			}
		}

		return map;
	}

	public static <TSource, TKey> Map<TKey, TSource> toMap(Iterable<TSource> source,
			Function<TSource, TKey> keySelector) throws IllegalAccessException {
		if (source == null)
			throw new IllegalAccessException("source is null");
		if (keySelector == null)
			throw new IllegalAccessException("keySelector is null");

		Map<TKey, TSource> map = new HashMap<TKey, TSource>();
		for (TSource element : source) {
			TKey key = keySelector.apply(element);
			map.put(key, element);
		}

		return map;
	}

	public static <TSource, TKey> Map<TKey, TSource> toMap(Iterable<TSource> source,
			Function<TSource, TKey> keySelector, Comparator<TKey> comparator) throws IllegalAccessException {
		if (source == null)
			throw new IllegalAccessException("source is null");
		if (keySelector == null)
			throw new IllegalAccessException("keySelector is null");

		Map<TKey, TSource> map = new HashMap<TKey, TSource>();
		for (TSource element : source) {
			TKey key = keySelector.apply(element);

			for (TKey mappedKey : map.keySet()) {
				if (comparator.compare(key, mappedKey) > 0) {
					map.put(key, element);
				}
			}
		}

		return map;
	}

	public static <TSource> Set<TSource> toSet(Iterable<TSource> source) throws IllegalAccessException {
		if (source == null)
			throw new IllegalAccessException("source is null");

		Set<TSource> set = new HashSet<TSource>();
		for (TSource element : source)
			set.add(element);

		return set;
	}

	// TODO: Add here ToLookup methods

	public static <TSource> Iterable<TSource> union(Iterable<TSource> first, Iterable<TSource> second) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> union(Iterable<TSource> first, Iterable<TSource> second,
			Comparator<TSource> comparator) {
		throw new UnsupportedOperationException();
	}

	public static <TSource> Iterable<TSource> where(Iterable<TSource> source, Predicate<TSource> predicate)
			throws IllegalAccessException {
		if (source == null)
			throw new IllegalAccessException("source is null");
		if (predicate == null)
			throw new IllegalAccessException("predicate is null");

		return new WhereIterator<TSource>(source, predicate);
	}

	public static <TFirst, TSecond, TResult> Iterable<TResult> zip(Iterable<TFirst> first, Iterable<TSecond> second,
			Function2<TFirst, TSecond, TResult> resultSelector) throws IllegalAccessException {
		if (first == null)
			throw new IllegalAccessException("first is null");
		if (second == null)
			throw new IllegalAccessException("second is null");
		if (resultSelector == null)
			throw new IllegalAccessException("resultSelector is null");

		return new ZipIterator<TFirst, TSecond, TResult>(first, second, resultSelector);
	}
}
