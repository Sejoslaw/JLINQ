import java.util.UUID;

public class Customer {
	public UUID id;
	public String name;
	public int age;

	public Customer(String name, int age) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return "Customer[" + "Id=" + this.id + ",Name=" + this.name + ",Age=" + this.age + "]";
	}
}