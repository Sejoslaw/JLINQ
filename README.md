# JLINQ
Java Language Integrated Query.

.NET LINQ equivalent. Create LINQ queries in Java.


To be implemented LINQ methods:
---
- [X] aggregate
- [X] all
- [X] any
- [X] asIterable
- [X] asNumbered (arithmetic operations - average, max, min, sum)
- [ ] asParallel
- [X] average
- [X] cast
- [X] concat
- [X] contains
- [X] count
- [X] defaultIfEmpty
- [X] distinct
- [X] elementAt
- [X] elementAtOrDefault
- [X] empty
- [X] except
- [X] first
- [X] firstOrDefault
- [X] forEach
- [ ] groupBy 
- [ ] groupJoin
- [X] indexOf
- [X] intersect
- [ ] join
- [X] last
- [X] lastOrDefault
- [X] longCount
- [X] max
- [X] min
- [ ] orderBy 
- [ ] orderByDescending 
- [X] range
- [X] repeat
- [X] replaceAt
- [X] replaceMultiple
- [X] reverse
- [X] select
- [X] selectMany
- [X] sequenceEqual
- [X] single
- [X] singleOrDefault
- [X] skip
- [X] skipWhile
- [X] sum
- [X] take
- [X] takeWhile
- [X] toArray
- [X] toList
- [X] toMap
- [X] toSet
- [X] union
- [X] where
- [X] zip


TODO / FINISHED:
---
- [X] Documentation !!!
- [X] Add support for basic math operations for whole collection. (See: [INumberedJLinqWrapper](https://github.com/Sejoslaw/JLINQ/blob/master/JLINQ/src/jlinq/interfaces/INumberJLinqWrapper.java))
- [ ] Add handler for IQueryable and IQueryProvider.
- [ ] Add support for parallel operations.


Examples:
---

1. Retrieve some data.

C#:
```csharp
using System.Linq;

int count = myEnumerable.Where((customer) => customer.Age == 24).Count();
```
Above example is equivalent with:

Java:
```java
package jlinq; // Main package which contains all JLinq methods and classes.

// THERE ARE 2 WAYS OF USING JLINQ !!!

// In first method you can handle each method yourself using JLinq static methods.
Iterable<Customer> customersWithAge24Iterator = JLinq.where(customers, (customer) -> customer.age == 24);
List<Customer> customersWithAge24 = JLinq.toList(customersWithAge24Iterator);
int count = JLinq.count(customersWithAge24);

// In second method you can use wrapper for JLinq which will give you more freedom of using multiple method calls / streams:
// Where as constructor parameter you must specify the Iterable on which you want to use JLinq.
int wrapperCount = new JLinqWrapper<Customer>(customers).where((customer) -> customer.age == 24).count();
```

See test projects for more info: [Basic Operations](https://github.com/Sejoslaw/JLINQ/blob/master/JLINQ_BasicTests/src/Main.java)
