import java.util.ArrayList;
import java.util.List;

import jlinq.JLinq;
import jlinq.JLinqWrapper;

public class Main {

	public static void main(String[] args) throws IllegalAccessException {

		List<Customer> customers = new ArrayList<Customer>();

		fillCustomers(customers);

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