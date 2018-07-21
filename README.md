# JLINQ
Java Language Integrated Query.

.NET LINQ equivalent. Create LINQ queries in Java.


To be implemented LINQ methods:
---
- [X] aggregate
- [X] all
- [X] any
- [X] asIterable
- [ ] average
- [X] cast
- [X] concat
- [X] contains
- [X] count
- [ ] defaultIfEmpty
- [ ] distinct
- [ ] elementAt
- [ ] elementAtOrDefault
- [X] empty
- [ ] except
- [ ] find
- [ ] first
- [ ] firstOrDefault
- [X] forEach
- [ ] groupBy 
- [ ] groupJoin
- [ ] indexOf
- [ ] intersect
- [ ] join
- [ ] last
- [ ] lastOrDefault
- [ ] longCount
- [ ] max
- [ ] min
- [ ] ofType
- [ ] orderBy 
- [ ] orderByDescending 
- [ ] range
- [ ] repeat
- [ ] replaceAt
- [ ] replaceMultiple
- [ ] reverse
- [ ] select
- [ ] selectMany
- [ ] sequenceEqual
- [ ] single
- [ ] singleOrDefault
- [ ] skip
- [ ] skipWhile
- [X] take
- [X] takeWhile
- [X] toArray
- [X] toList
- [X] toMap
- [X] toSet
- [X] union
- [X] where
- [X] zip


TODO:
---
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
