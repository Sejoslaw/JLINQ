import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jlinq.JLinqWrapper;
import jlinq.queryable.InMemoryQueryableWrapper;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public class Main {

	private List<Integer> values = new ArrayList<Integer>();

	public Main() {
		for (int i = 0; i < 1000; ++i) {
			this.values.add(i);
		}
	}

	@Test
	public void testQueryable() throws IllegalAccessException {
		System.out.println("---=== Testing Queryables ===---");
		testQueryable(this.values);
		System.out.println("---=== Finished Testing Queryables ===---");
	}

	private static void testQueryable(List<Integer> x) throws IllegalAccessException {
		// Where second parameter (null here) is an database Connection.
		new InMemoryQueryableWrapper<>(new JLinqWrapper<>(x)).where(val -> val % 200 == 0)
				.forEach(val -> System.out.println(val));
	}
}