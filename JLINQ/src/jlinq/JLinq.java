package jlinq;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import jlinq.comparators.DefaultComparator;
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

		TSource result = getDefaultValue(source);
		for (TSource element : source) {
			result = func.apply(result, element);
		}

		return result;
	}

	public static <TSource> boolean all(Iterable<TSource> source, Predicate<TSource> predicate) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (predicate == null)
			throw new IllegalArgumentException("predicate is null");

		for (TSource element : source)
			if (!predicate.test(element))
				return false;

		return true;
	}

	public static <TSource> boolean any(Iterable<TSource> source) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		return source.iterator().hasNext();
	}

	public static <TSource> boolean any(Iterable<TSource> source, Predicate<TSource> predicate) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (predicate == null)
			throw new IllegalArgumentException("predicate is null");

		for (TSource element : source)
			if (predicate.test(element))
				return true;

		return false;
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
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (func == null)
			throw new IllegalArgumentException("func is null");

		return new CastIterator<TSource, TResult>(source, func);
	}

	public static <TSource> Iterable<TSource> concat(Iterable<TSource> first, Iterable<TSource> second) {
		if (first == null)
			throw new IllegalArgumentException("first is null");
		if (second == null)
			throw new IllegalArgumentException("second is null");

		return new ConcatIterator<TSource>(first, second);
	}

	public static <TSource> boolean contains(Iterable<TSource> source, TSource value) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (value == null)
			throw new IllegalArgumentException("value is null");

		return contains(source, value, null);
	}

	public static <TSource> boolean contains(Iterable<TSource> source, TSource value, Comparator<TSource> comparator) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (value == getDefaultValue(source))
			throw new IllegalArgumentException("value is null");
		if (comparator == null)
			comparator = new DefaultComparator<TSource>();

		for (TSource element : source)
			if (comparator.compare(element, value) == 0)
				return true;
		return false;
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
		if (source == null)
			throw new IllegalArgumentException("source is null");

		return defaultIfEmpty(source, getDefaultValue(source));
	}

	public static <TSource> Iterable<TSource> defaultIfEmpty(Iterable<TSource> source, TSource defaultValue) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (defaultValue == getDefaultValue(source))
			throw new IllegalArgumentException("defaultValue is null");

		return new DefaultIfEmptyIterator<TSource>(source, defaultValue);
	}

	public static <TSource> Iterable<TSource> distinct(Iterable<TSource> source) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		return new DistinctIterator<TSource>(source);
	}

	public static <TSource> TSource elementAt(Iterable<TSource> source, int index) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (index < 0)
			throw new IllegalArgumentException("index is less than 0");

		Iterator<TSource> iterator = source.iterator();
		TSource element = getDefaultValue(source);
		while (true) {
			if (iterator.hasNext()) {
				element = iterator.next();
				if (index == 0) {
					return element;
				} else {
					index--;
				}
			} else {
				throw new IndexOutOfBoundsException("Index [" + index + "] is out of bounds");
			}
		}
	}

	public static <TSource> TSource elementAtOrDefault(Iterable<TSource> source, int index) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		Iterator<TSource> iterator = source.iterator();
		TSource element = getDefaultValue(source);
		while (true) {
			if (iterator.hasNext()) {
				element = iterator.next();
				if (index == 0) {
					return element;
				} else {
					index--;
				}
			} else {
				break;
			}
		}

		return getDefaultValue(source);
	}

	public static <TSource> Iterable<TSource> empty() {
		return new ArrayList<TSource>();
	}

	public static <TSource> Iterable<TSource> except(Iterable<TSource> first, Iterable<TSource> second) {
		if (first == null)
			throw new IllegalArgumentException("first is null");
		if (second == null)
			throw new IllegalArgumentException("second is null");

		return new ExceptIterator<TSource>(first, second);
	}

	public static <TSource> TSource first(Iterable<TSource> source) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		Iterator<TSource> iterator = source.iterator();
		if (iterator.hasNext())
			return iterator.next();

		throw new IllegalArgumentException("source contains no elements");
	}

	public static <TSource> TSource first(Iterable<TSource> source, Predicate<TSource> predicate) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		for (TSource element : source)
			if (predicate.test(element))
				return element;

		throw new IllegalArgumentException("no matches");
	}

	public static <TSource> TSource firstOrDefault(Iterable<TSource> source) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		Iterator<TSource> iterator = source.iterator();
		if (iterator.hasNext())
			return iterator.next();

		return getDefaultValue(source);
	}

	public static <TSource> TSource firstOrDefault(Iterable<TSource> source, Predicate<TSource> predicate) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		for (TSource element : source)
			if (predicate.test(element))
				return element;

		return getDefaultValue(source);
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
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (element == getDefaultValue(source))
			throw new IllegalArgumentException("element is null");

		int index = 0;
		for (TSource sourceElement : source) {
			if (sourceElement == element)
				return index;
			index++;
		}

		throw new IllegalArgumentException("no matches");
	}

	public static <TSource> Iterable<TSource> intersect(Iterable<TSource> first, Iterable<TSource> second) {
		if (first == null)
			throw new IllegalArgumentException("first is null");
		if (second == null)
			throw new IllegalArgumentException("second is null");

		return new IntersectIterator<TSource>(first, second);
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

	public static <TSource> TSource last(Iterable<TSource> source) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		Iterator<TSource> iterator = source.iterator();
		TSource element = getDefaultValue(source);
		if (iterator.hasNext()) {
			while (iterator.hasNext())
				element = iterator.next();
			return element;
		}

		throw new IllegalArgumentException("no elements in source");
	}

	public static <TSource> TSource last(Iterable<TSource> source, Predicate<TSource> predicate) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (predicate == null)
			throw new IllegalArgumentException("predicate is null");

		boolean foundLast = false;
		TSource found = getDefaultValue(source);
		for (TSource element : source) {
			if (predicate.test(element)) {
				foundLast = true;
				found = element;
			}
		}

		if (foundLast)
			return found;

		throw new IllegalArgumentException("no matches");
	}

	public static <TSource> TSource lastOrDefault(Iterable<TSource> source) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		Iterator<TSource> iterator = source.iterator();
		TSource element = getDefaultValue(source);
		if (iterator.hasNext()) {
			while (iterator.hasNext())
				element = iterator.next();
			return element;
		}

		return getDefaultValue(source);
	}

	public static <TSource> TSource lastOrDefault(Iterable<TSource> source, Predicate<TSource> predicate) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (predicate == null)
			throw new IllegalArgumentException("predicate is null");

		boolean foundLast = false;
		TSource found = getDefaultValue(source);
		for (TSource element : source) {
			if (predicate.test(element)) {
				foundLast = true;
				found = element;
			}
		}

		if (foundLast)
			return found;

		return getDefaultValue(source);
	}

	public static <TSource> long longCount(Iterable<TSource> source) {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		long count = 0;
		for (TSource element : source)
			count++;

		return count;
	}

	public static <TSource> long longCount(Iterable<TSource> source, Predicate<TSource> predicate) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (predicate == null)
			throw new IllegalArgumentException("predicate is null");

		long count = 0;
		for (TSource element : source)
			if (predicate.test(element))
				count++;

		return count;
	}

	// TODO: Add here Max methods

	// TODO: Add here Min methods

	// TODO: Add here OrderBy and OrderByDescending methods

	public static Iterable<Integer> range(int start, int count) {
		if (count < 0)
			throw new IllegalArgumentException("count < 0");

		return new RangeIterator(start, count);
	}

	public static <TResult> Iterable<TResult> repeat(TResult element, int count) {
		if (count < 0)
			throw new IllegalArgumentException("count < 0");

		return new RepeatIterator<TResult>(element, count);
	}

	public static <TSource> Iterable<TSource> replaceAt(Iterable<TSource> source, int index, TSource newValue) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (index < 0)
			throw new IllegalArgumentException("index < 0");
		if (newValue == getDefaultValue(source))
			throw new IllegalArgumentException("newValue is null");

		return new ReplaceAtIterator<TSource>(source, index, newValue);
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
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (newValue == getDefaultValue(source))
			throw new IllegalArgumentException("newValue is null");
		if (predicate == null)
			throw new IllegalArgumentException("predicate is null");

		return new ReplaceMultipleIterator<TSource>(source, newValue, predicate);
	}

	public static <TSource> Iterable<TSource> reverse(Iterable<TSource> source) throws IllegalAccessException {
		if (source == null)
			throw new IllegalArgumentException("source is null");

		return new ReverseIterator<TSource>(source);
	}

	public static <TSource, TResult> Iterable<TResult> select(Iterable<TSource> source,
			Function<TSource, TResult> selector) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (selector == null)
			throw new IllegalArgumentException("selector is null");

		return new SelectIterator<TSource, TResult>(source, selector);
	}

	public static <TSource, TResult> Iterable<TResult> selectMany(Iterable<TSource> source,
			Function<TSource, Iterable<TResult>> selector) {
		if (source == null)
			throw new IllegalArgumentException("source is null");
		if (selector == null)
			throw new IllegalArgumentException("selector is null");
		
		return new SelectMany<TSource, TResult, Iterable<TResult>>(source, selector);
	}

	public static <TSource, TCollection, TResult> Iterable<TResult> selectMany(Iterable<TSource> source,
			Function<TSource, Iterable<TCollection>> collectionSelector,
			Function2<TSource, TCollection, TResult> resultSelector) {
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

	public static <TSource> Iterable<TSource> union(Iterable<TSource> first, Iterable<TSource> second)
			throws IllegalAccessException {
		if (first == null)
			throw new IllegalAccessException("first is null");
		if (second == null)
			throw new IllegalAccessException("second is null");

		return new UnionIterator<TSource>(first, second);
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

	// ---=== Private Methods ===---

	@SuppressWarnings("unchecked")
	private static <TSource> TSource getDefaultValue(Iterable<TSource> source) {
		try {
			return (TSource) (Object) null;
		} catch (Exception ex) {
			return (TSource) (Object) 0;
		}
	}
}
