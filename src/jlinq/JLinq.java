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
 * Main entry point of JLINQ library.
 * JLINQ operates on {@link Iterable} level which is lower than {@link Collection} level.
 * JLINQ provides all of the basic operations which LINQ does.
 * 
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public class JLinq {
	
	private JLinq() {
	}
	
	public static <TSource> TSource aggregate(Iterable<TSource> source, Function<TSource, TSource> func) {
	}
	
	public static <TSource> boolean all(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> boolean any(Iterable<TSource> source) {
	}
	
	public static <TSource> boolean any(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> Iterable<TSource> asIterable(Iterable<TSource> source) {
	}
	
	// TODO: Add here Average methods
	
	public static <TSource, TResult> Iterable<TResult> cast(Iterable<TSource> source, Function<TSource, TResult> func) {
	}
	
	public static <TSource> Iterable<TSource> concat(Iterable<TSource> first, Iterable<TSource> second) {
	}
	
	public static <TSource> boolean contains(Iterable<TSource> source, TSource value) {
	}
	
	public static <TSource> boolean contains(Iterable<TSource> source, TSource value, Comparator<TSource> comparator) {
	}
	
	public static <TSource> int count(Iterable<TSource> source) {
	}
	
	public static <TSource> int count(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> Iterable<TSource> defaultIfEmpty(Iterable<TSource> source) {
	}
	
	public static <TSource> Iterable<TSource> defaultIfEmpty(Iterable<TSource> source, TSource defaultValue) {
	}
	
	public static <TSource> Iterable<TSource> distinct(Iterable<TSource> source) {
	}
	
	public static <TSource> Iterable<TSource> distinct(Iterable<TSource> source, Comparator<TSource> comparator) {
	}
	
	public static <TSource> TSource elementAt(Iterable<TSource> source, int index) {
	}
	
	public static <TSource> TSource elementAtOrDefault(Iterable<TSource> source, int index) {
	}
	
	public static <TSource> Iterable<TSource> empty() {
		return new ArrayList<TSource>();
	}
	
	public static <TSource> Iterable<TSource> except(Iterable<TSource> first, Iterable<TSource> second) {
	}
	
	public static <TSource> Iterable<TSource> except(Iterable<TSource> first, Iterable<TSource> second, Comparator<TSource> comparator) {
	}
	
	/**
	 * @param source
	 * @param element
	 * @return Returns all occurance which fulfil specified selector.
	 */
	public static <TSource> Iterable<TSource> find(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> TSource first(Iterable<TSource> source) {
	}
	
	public static <TSource> TSource first(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> TSource firstOrDefault(Iterable<TSource> source) {
	}
	
	public static <TSource> TSource firstOrDefault(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> void forEach(Iterable<TSource> source, Consumer<TSource> action) {
		if (source == null ||
			action == null) {
			return;
		}
		
		for (TSource element : source) {
			action.accept(element);
		}
	}
	
	// TODO: Add here GroupBy methods
	
	public static <TOuter, TInner, TKey, TResult> Iterable<TResult> groupJoin(Iterable<TOuter> outer, Iterable<TInner> inner, Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector, Function2<TOuter, Iterable<TInner>, TResult> resultSelector) {
	}
	
	public static <TOuter, TInner, TKey, TResult> Iterable<TResult> groupJoin(Iterable<TOuter> outer, Iterable<TInner> inner, Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector, Function2<TOuter, Iterable<TInner>, TResult> resultSelector, Comparator<TKey> comparator) {
	}
	
	public static <TSource> int indexOf(Iterable<TSource> source, TSource element) {
	}
	
	public static <TSource> Iterable<TSource> intersect(Iterable<TSource> first, Iterable<TSource> second) {
	}
	
	public static <TSource> Iterable<TSource> intersect(Iterable<TSource> first, Iterable<TSource> second, Comparator<TSource> comparator) {
	}
	
	public static <TOuter, TInner, TKey, TResult> Iterable<TResult> join(Iterable<TOuter> outer, Iterable<TInner> inner, Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector, Function2<TOuter, TInner, TResult> resultSelector) {
	}
	
	public static <TOuter, TInner, TKey, TResult> Iterable<TResult> join(Iterable<TOuter> outer, Iterable<TInner> inner, Function<TOuter, TKey> outerKeySelector, Function<TInner, TKey> innerKeySelector, Function2<TOuter, TInner, TResult> resultSelector, Comparator<TKey> comparator) {
	}
	
	public static <TSource> TSource last(Iterable<TSource> first) {
	}
	
	public static <TSource> TSource last(Iterable<TSource> first, Predicate<TSource> predicate) {
	}
	
	public static <TSource> TSource lastOrDefault(Iterable<TSource> source) {
	}
	
	public static <TSource> TSource lastOrDefault(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> long longCount(Iterable<TSource> source) {
	}
	
	public static <TSource> long longCount(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	// TODO: Add here Max methods
	
	// TODO: Add here Min methods
	
	public static <TSource> Iterable<TSource> ofType(Iterable source) {
	}
	
	// TODO: Add here OrderBy and OrderByDescending methods
	
	public static Iterable<Integer> range(int start, int count) {
	}
	
	public static <TResult> Iterable<TResult> repeat(TResult element, int count) {
	}
	
	public static <TSource> Iterable<TSource> replaceAt(Iterable<TSource> source, int index, TSource newValue) {
	}
	
	/**
	 * @param source
	 * @param newValue
	 * @param predicate
	 * @return Replaces all occurrence which fulfil the predicate with new specified value.
	 */
	public static <TSource> Iterable<TSource> replaceMultiple(Iterable<TSource> source, TSource newValue, Predicate<TSource> predicate) {
	}
	
	public static <TSource> Iterable<TSource> reverse(Iterable<TSource> source) {
	}
	
	public static <TSource, TResult> Iterable<TResult> select(Iterable<TSource> source, Function<TSource, TResult> selector) {
	}
	
	public static <TSource, TResult> Iterable<TResult> select(Iterable<TSource> source, Function2<TSource, Integer, TResult> selector) {
	}
	
	public static <TSource, TResult> Iterable<TResult> selectMany(Iterable<TSource> source, Function<TSource, Iterable<TResult>> selector) {
	}
	
	public static <TSource, TCollection, TResult> Iterable<TResult> selectMany(Iterable<TSource> source, Function<TSource, Iterable<TCollection>> collectionSelector, Function2<TSource, TCollection, TResult> resultSelector) {
	}
	
	public static <TSource, TCollection, TResult> Iterable<TResult> selectMany(Iterable<TSource> source, Function2<TSource, Integer, Iterable<TCollection>> collectionSelector, Function2<TSource, TCollection, TResult> resultSelector) {
	}
	
	public static <TSource, TResult> Iterable<TResult> selectMany(Iterable<TSource> source, Function2<TSource, Integer, Iterable<TResult>> selector) {
	}
	
	public static <TSource> boolean sequenceEqual(Iterable<TSource> first, Iterable<TSource> second) {
	}
	
	public static <TSource> boolean sequenceEqual(Iterable<TSource> first, Iterable<TSource> second, Comparator<TSource> comparator) {
	}
	
	public static <TSource> TSource single(Iterable<TSource> source) {
	}
	
	public static <TSource> TSource single(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> TSource singleOrDefault(Iterable<TSource> source) {
	}
	
	public static <TSource> TSource singleOrDefault(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> Iterable<TSource> skip(Iterable<TSource> source, int count) {
	}
	
	public static <TSource> Iterable<TSource> skipWhile(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> Iterable<TSource> skipWhile(Iterable<TSource> source, Function2<TSource, Integer, Boolean> predicate) {
	}
	
	// TODO: Add here Sum methods
	
	public static <TSource> Iterable<TSource> take(Iterable<TSource> source, int count) {
	}
	
	public static <TSource> Iterable<TSource> takeWhile(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> Iterable<TSource> takeWhile(Iterable<TSource> source, Function2<TSource, Integer, Boolean> predicate) {
	}
	
	// TODO: Add here ThenBy and ThenByDescending methods
	
	public static <TSource> TSource[] toArray(Iterable<TSource> source) {
	}
	
	public static <TSource> List<TSource> toList(Iterable<TSource> source) {
	}
	
	public static <TSource, TKey, TElement> Map<TKey, TElement> toMap(Iterable<TSource> source, Function<TSource, TKey> keySelector, Function<TSource, TElement> elementSelector) {
	}
	
	public static <TSource, TKey, TElement> Map<TKey, TElement> toMap(Iterable<TSource> source, Function<TSource, TKey> keySelector, Function<TSource, TElement> elementSelector, Comparator<TKey> comparator) {
	}
	
	public static <TSource, TKey> Map<TKey, TSource> toMap(Iterable<TSource> source, Function<TSource, TKey> keySelector) {
	}
	
	public static <TSource, TKey> Map<TKey, TSource> toMap(Iterable<TSource> source, Function<TSource, TKey> keySelector, Comparator<TKey> comparator) {
	}
	
	public static <TSource> Set<TSource> toSet(Iterable<TSource> source) {
	}
	
	// TODO: Add here ToLookup methods
	
	public static <TSource> Iterable<TSource> union(Iterable<TSource> first, Iterable<TSource> second) {
	}
	
	public static <TSource> Iterable<TSource> union(Iterable<TSource> first, Iterable<TSource> second, Comparator<TSource> comparator) {
	}
	
	public static <TSource> Iterable<TSource> where(Iterable<TSource> source, Predicate<TSource> predicate) {
	}
	
	public static <TSource> Iterable<TSource> where(Iterable<TSource> source, Function2<TSource, Integer, Boolean> predicate) {
	}
	
	public static <TFirst, TSecond, TResult> Iterable<TResult> zip(Iterable<TFirst> first, Iterable<TSecond> second, Function2<TFirst, TSecond, TResult> resultSelector) {
	}
}
