import java.util.UUID;

public class Customer {
	public String id;
	public String name;
	public int age;

	public Customer(String name, int age) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Customer[Id=" + this.id + ",Name=" + this.name + ",Age=" + this.age + "]";
	}
}