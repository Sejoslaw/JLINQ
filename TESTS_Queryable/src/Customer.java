import java.util.UUID;

public class Customer {
	public UUID Id;
	public String Name;
	public int Age;

	public Customer(String name, int age) {
		this.Id = UUID.randomUUID();
		this.Name = name;
		this.Age = age;
	}

	public String toString() {
		return "Customer[" + "Id=" + this.Id + ",Name=" + this.Name + ",Age=" + this.Age + "]";
	}
}