import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import jlinq.JLinq;
import jlinq.JLinqWrapper;
import jlinq.parallel.DefaultParallelQueryOptions;
import jlinq.queryable.InMemoryQueryableWrapper;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public class Main {

	public static void main(String[] args) throws IllegalAccessException, InterruptedException, ExecutionException {

		List<Customer> customers = new ArrayList<Customer>();

		List<Integer> x = new ArrayList<Integer>();

		for (int i = 0; i < 1000; ++i)
			x.add(i);

		fillCustomers(customers);

		System.out.println("---=== Testing Basic Operations ===---");
		testBasicOperations(customers, x);
		System.out.println("---=== Finished Testing Basic Operations ===---");

		System.out.println("---=== Testing Parallel Operations ===---");
		testParallelOperations(customers, x);
		System.out.println("---=== Finished Testing Parallel Operations ===---");

		System.out.println("---=== Testing Queryables ===---");
		testQueryable(customers, x);
		System.out.println("---=== Finished Testing Queryables ===---");

		System.out.println("---=== Cheking Times For JLINQ and Streams API ===---");
		checkTimes();
		System.out.println("---=== Finished Cheking Times For JLINQ and Streams API ===---");

		System.out.println("---=== Cheking Times For Parallel JLINQ and Streams API ===---");
		checkTimesParallel();
		System.out.println("---=== Finished Cheking Times For Parallel JLINQ and Streams API ===---");
	}

	private static void testQueryable(List<Customer> customers, List<Integer> x) throws IllegalAccessException {
		// Where second parameter (null here) is an database Connection.
		new InMemoryQueryableWrapper<>(new JLinqWrapper<>(x)).where(val -> val % 200 == 0)
				.forEach(val -> System.out.println(val));
	}

	private static void testParallelOperations(List<Customer> customers, List<Integer> x)
			throws IllegalAccessException, InterruptedException, ExecutionException {
		// Print Customers in parallel
		new JLinqWrapper<Customer>(customers).asParallel(new DefaultParallelQueryOptions(3)).forAll(
				customer -> System.out.println("Thread Id: " + Thread.currentThread().getId() + " - " + customer.name));

		System.out.println();

		// Print integers in parallel
		new JLinqWrapper<Integer>(x).asParallel(new DefaultParallelQueryOptions(5))
				.where(val -> val.intValue() % 3 == 0)
				.forAll(number -> System.out.println("Thread Id: " + Thread.currentThread().getId() + " - " + number));

		System.out.println();

		System.out.println("Values are lower than max: " + new JLinqWrapper<Integer>(x)
				.asParallel(new DefaultParallelQueryOptions(5)).all(val -> val < Integer.MAX_VALUE));
		System.out.println("One of values is equal 10: "
				+ new JLinqWrapper<Integer>(x).asParallel(new DefaultParallelQueryOptions(5)).any(val -> val == 10));
		int count = new JLinqWrapper<Integer>(x).asParallel(new DefaultParallelQueryOptions(5)).count();
		System.out.println("Number of elements counted by parallel query: " + count);

		System.out.println();
	}

	private static void testBasicOperations(List<Customer> customers, List<Integer> x) throws IllegalAccessException {
		// Raw version using only JLinq main class.
		Iterable<Customer> customersWithAge24Iterator = JLinq.where(customers, (customer) -> customer.age == 24);
		List<Customer> customersWithAge24 = JLinq.toList(customersWithAge24Iterator);
		int count = JLinq.count(customersWithAge24);
		System.out.println(count);

		// The same version as above using JLinqWrapper class which wraps all JLinq
		// methods.
		int wrapperCount = new JLinqWrapper<Customer>(customers).where((customer) -> customer.age == 24).count();
		System.out.println(wrapperCount);

		System.out.println(new JLinqWrapper<Customer>(new ArrayList<Customer>()).any());
		System.out.println(new JLinqWrapper<Customer>(customers).any());
		System.out.println(new JLinqWrapper<Customer>(customers).elementAt(5).name);

		new JLinqWrapper<Integer>().range(0, 10).forEach((value) -> System.out.print(value + ", "));
		System.out.println();
		new JLinqWrapper<Integer>().range(0, 10).reverse().forEach((value) -> System.out.print(value + ", "));
		System.out.println();
		new JLinqWrapper<Integer>().repeat(1, 10).forEach((value) -> System.out.print(value + ", "));
		System.out.println();
		new JLinqWrapper<Integer>().range(0, 10).replaceAt(5, -1).forEach((value) -> System.out.print(value + ", "));
		System.out.println();
		new JLinqWrapper<Integer>().range(0, 10).replaceAt(5, 1).replaceAt(6, 1)
				.replaceMultiple(5, (value) -> value == 1).forEach((value) -> System.out.print(value + ", "));
		System.out.println();

		new JLinqWrapper<Customer>(customers).select((customer) -> customer.age)
				.forEach((age) -> System.out.print(age + ", "));
		System.out.println();

		new JLinqWrapper<Integer>().range(0, 5).selectMany((value) -> {
			List<Integer> list = new ArrayList<Integer>();
			list.add(88);
			list.add(99);
			return list;
		}).forEach((value) -> System.out.print(value + ", "));
		System.out.println();

		new JLinqWrapper<Integer>().range(0, 10).skip(3).forEach((value) -> System.out.print(value + ", "));
		System.out.println();
		new JLinqWrapper<Integer>().range(0, 10).skipWhile(value -> value <= 3)
				.forEach((value) -> System.out.print(value + ", "));
		System.out.println();

		System.out.println(new JLinqWrapper<Customer>().firstOrDefault());
		System.out.println(new JLinqWrapper<Integer>(x).firstOrDefault());
		System.out.println(new JLinqWrapper<Integer>(x).lastOrDefault());

		System.out.println("NumberedJLinqWrapper example:");
		System.out
				.println("Sumed value = " + new JLinqWrapper<Integer>().range(0, 5).asNumbered(number -> number).sum());
		System.out.println(
				"Average value = " + new JLinqWrapper<Integer>().range(0, 5).asNumbered(number -> number).average());
		System.out.println("Max value = " + new JLinqWrapper<Integer>().range(0, 5).asNumbered(number -> number).max());
		System.out.println("Min value = " + new JLinqWrapper<Integer>().range(0, 5).asNumbered(number -> number).min());
		System.out.println("Average customers age: "
				+ new JLinqWrapper<Customer>(customers).asNumbered(customer -> customer.age).average());

		System.out.println();
	}

	private static void checkTimes() {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < 10000000; ++i)
			list.add(i);

		// Where -> Count
		PrintElapsedTime(() -> {
			try {
				new JLinqWrapper<Integer>(list).where(value -> value / 3 == 0).count();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});

		PrintElapsedTime(() -> {
			list.stream().filter(value -> value / 3 == 0).count();
		});

		System.out.println();
	}

	private static void checkTimesParallel() {
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < 10000000; ++i)
			list.add(i);

		// Where -> Count
		PrintElapsedTime(() -> {
			try {
				new JLinqWrapper<Integer>(list).asParallel(new DefaultParallelQueryOptions(10))
						.where(value -> value % 3 == 0).count();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});

		PrintElapsedTime(() -> {
			list.stream().parallel().filter(value -> value % 3 == 0).count();
		});

		System.out.println();
	}

	private static <TSource> void PrintElapsedTime(Runnable runnable) {
		long start = System.nanoTime();
		runnable.run();
		long end = System.nanoTime();

		System.out.println("Elapsed Time: " + (end - start));
	}

	private static void fillCustomers(List<Customer> customers) {
		customers.add(new Customer("Krzysztof", 24));
		customers.add(new Customer("Ilona", 28));
		customers.add(new Customer("Ethan", 27));
		customers.add(new Customer("Marta", 21));
		customers.add(new Customer("Michal", 24));
		customers.add(new Customer("Kasia", 25));
		customers.add(new Customer("Jasiek", 47));
		customers.add(new Customer("Dan", 36));
		customers.add(new Customer("Mateusz", 25));
		customers.add(new Customer("Ela", 24));
	}
}