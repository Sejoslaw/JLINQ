import java.sql.Connection;
import java.sql.DriverManager;

import jlinq.queryable.IQueryableJLinqWrapper;
import jlinq.queryable.JLinqQueryable;
import jlinq.queryable.mysql.MySqlQueryableJLinqWrapper;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public class Main {
	public static void main(String[] args) {

		System.out.println("Testing JLINQ.Queryable version: " + JLinqQueryable.VERSION);
		System.out.println();
		
		System.out.println("---=== Testing MySQL Queries (version: " + MySqlQueryableJLinqWrapper.VERSION + ") ===---");
		testMySQLQueries();
		System.out.println("---=== Finished Testing MySQL Queries ===---");
	}

	/**
	 * Executed MySQL commands:
	 * 1. CREATE USER 'JLINQ'@'localhost' IDENTIFIED VIA mysql_native_password USING '***';GRANT ALL PRIVILEGES ON *.* TO 'JLINQ'@'%' REQUIRE NONE WITH GRANT OPTION MAX_QUERIES_PER_HOUR 0 MAX_CONNECTIONS_PER_HOUR 0 MAX_UPDATES_PER_HOUR 0 MAX_USER_CONNECTIONS 0;CREATE DATABASE IF NOT EXISTS `JLINQ`;GRANT ALL PRIVILEGES ON `JLINQ`.* TO 'JLINQ'@'%';GRANT ALL PRIVILEGES ON `JLINQ\_%`.* TO 'JLINQ'@'%';
	 * 2. CREATE TABLE `jlinq`.`MyCustomers` ( `Id` VARCHAR(50) NOT NULL , `Name` VARCHAR(100) NOT NULL , `Age` INT(100) NOT NULL , PRIMARY KEY (`Id`)) ENGINE = InnoDB;
	 * 3. Inserts:
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('2b676928-52b5-4eba-a039-0e82b585dcb1', 'Krzysztof', '24'); 
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('77791f73-df39-4745-8521-8ccbc3cd5ce0', 'Ilona', '28'); 
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('4103b85d-cd23-4a16-9be3-f83b6e226816', 'Ethan', '27');
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('657d92a0-da92-4a86-a610-55f922ceec53', 'Marta', '21');
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('c5af4e83-f4fb-473a-9582-07172f82bc5e', 'Michal', '24');
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('be6c39fe-8f37-43b7-b7a9-c323f1978f09', 'Kasia', '25');
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('1bed03af-cc54-4dff-a8d8-1db9caa4a638', 'Jasiek', '47');
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('23576e47-88b2-49ec-8045-04ca1677af69', 'Dan', '36');
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('0c39119a-dd44-46b8-8e37-90ee42fe9f85', 'Mateusz', '25');
	 * INSERT INTO `mycustomers` (`Id`, `Name`, `Age`) VALUES ('b9ed8cf8-c2fa-415e-ba6d-8b4378c2baf9', 'Ela', '24');
	 * 4. CREATE TABLE `jlinq`.`Customer` ( `Id` VARCHAR(50) NOT NULL , `Name` VARCHAR(100) NOT NULL , `Age` INT(100) NOT NULL , PRIMARY KEY (`Id`)) ENGINE = InnoDB;
	 * 5. Inserts:
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('2b676928-52b5-4eba-a039-0e82b585dcb1', 'Krzysztof', '24'); 
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('77791f73-df39-4745-8521-8ccbc3cd5ce0', 'Ilona', '28'); 
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('4103b85d-cd23-4a16-9be3-f83b6e226816', 'Ethan', '27');
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('657d92a0-da92-4a86-a610-55f922ceec53', 'Marta', '21');
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('c5af4e83-f4fb-473a-9582-07172f82bc5e', 'Michal', '24');
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('be6c39fe-8f37-43b7-b7a9-c323f1978f09', 'Kasia', '25');
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('1bed03af-cc54-4dff-a8d8-1db9caa4a638', 'Jasiek', '47');
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('23576e47-88b2-49ec-8045-04ca1677af69', 'Dan', '36');
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('0c39119a-dd44-46b8-8e37-90ee42fe9f85', 'Mateusz', '25');
	 * INSERT INTO `customer` (`Id`, `Name`, `Age`) VALUES ('b9ed8cf8-c2fa-415e-ba6d-8b4378c2baf9', 'Ela', '24');
	 */
	private static void testMySQLQueries() {
		// Connection for the database
		Connection xamppConnection = PrepareXamppConnection();
		
		// New queryable for MySQL with the given table name as second parameter
		System.out.println("Test with table name specified:");
		IQueryableJLinqWrapper<Customer> mySqlQuery = new MySqlQueryableJLinqWrapper<>(Customer.class, xamppConnection, "mycustomers");
		mySqlQuery.forEach(customer -> System.out.println(customer));
		
		System.out.println();
		
		// Similar to above but in this case the query wrapper will parse table name from the generic argument class name.
		System.out.println("Test without table name specified:");
		mySqlQuery = new MySqlQueryableJLinqWrapper<>(Customer.class, xamppConnection);
		mySqlQuery.forEach(customer -> System.out.println(customer));
	}

	private static Connection PrepareXamppConnection() {
		String url = "jdbc:mysql://localhost:3306/jlinq";
		Connection con = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "JLINQ", "admin");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}
}