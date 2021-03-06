# JLINQ
Java Language Integrated Query.

.NET LINQ equivalent. Create LINQ queries in Java.


Projects:
---
| Name | Description |
| -----|-------------|
| [JLINQ](https://github.com/Sejoslaw/JLINQ/tree/master/JLINQ/src/main/java/jlinq) | Contains core interfaces and default implementation for JLINQ queries. |
| [W.I.P.] [JLINQ.Queryable](https://github.com/Sejoslaw/JLINQ/tree/master/JLINQ.Queryable/src/main/java/jlinq/queryable) | Contains core interfaces for executing JLINQ queries on data sources. |
| [W.I.P.] [JLINQ.Queryable.MySQL](https://github.com/Sejoslaw/JLINQ/tree/master/JLINQ.Queryable.MySQL/src/main/java/jlinq/queryable/mysql) | Contains query wrapper for MySQL database ([MySqlQueryableJLinqWrapper](https://github.com/Sejoslaw/JLINQ/blob/master/JLINQ.Queryable.MySQL/src/main/java/jlinq/queryable/mysql/MySqlQueryableJLinqWrapper.java)). |

To be implemented LINQ methods:
---
- [X] aggregate
- [X] all
- [X] any
- [X] asIterable
- [X] asNumbered (arithmetic operations - average, max, min, sum)
- [X] asParallel (parallel operations)
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
- [X] groupBy 
- [ ] groupJoin
- [X] indexOf
- [X] intersect
- [X] join
- [X] last
- [X] lastOrDefault
- [X] longCount
- [X] max
- [X] min
- [X] orderBy 
- [X] orderByDescending 
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
- [ ] thenBy
- [ ] thenByDescending
- [X] toArray
- [X] toList
- [ ] toLookup
- [X] toMap
- [X] toSet
- [X] union
- [X] where
- [X] zip


TODO / FINISHED:
---
- [X] Documentation !!!
- [X] Add support for basic math operations for whole collection. (See: [INumberedJLinqWrapper](https://github.com/Sejoslaw/JLINQ/blob/master/JLINQ/src/main/java/jlinq/interfaces/INumberJLinqWrapper.java))
- [ ] Add handler for IQueryable.
- [X] Add support for parallel operations. (See: [IParallelJLinqWrapper](https://github.com/Sejoslaw/JLINQ/blob/master/JLINQ/src/main/java/jlinq/interfaces/IParallelJLinqWrapper.java))


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
