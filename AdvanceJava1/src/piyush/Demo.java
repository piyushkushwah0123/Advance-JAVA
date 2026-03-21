package piyush;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {

	private static final String DBURL = "jdbc:mysql://localhost:3306/sqltypedb";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "root";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);

		Statement stmt = con.createStatement();

		stmt.addBatch("INSERT INTO books VALUES (101,'AI',2000.00)");
		stmt.addBatch("INSERT INTO books VALUES (102,'Java Programming',850.50)");
		stmt.addBatch("INSERT INTO books VALUES (103,'Python Basics',650.00)");
		stmt.addBatch("INSERT INTO books VALUES (104,'Data Structures',920.75)");
		stmt.addBatch("INSERT INTO books VALUES (105,'Machine Learning',1500.00)");
		stmt.addBatch("INSERT INTO books VALUES (106,'Deep Learning',1750.25)");
		stmt.addBatch("INSERT INTO books VALUES (107,'Web Development',720.00)");
		stmt.addBatch("INSERT INTO books VALUES (108,'HTML Guide',350.00)");
		stmt.addBatch("INSERT INTO books VALUES (109,'CSS Mastery',400.00)");
		stmt.addBatch("INSERT INTO books VALUES (110,'JavaScript Basics',550.00)");

	//	int[] rows = stmt.executeBatch();
	//	System.out.println("Total Record Inserted : " + rows.length);

		ResultSet rs = stmt.executeQuery("SELECT book_price % 2 AS price_type, Count(book_price) as total FROM books GROUP BY book_price % 2");

		System.out.println("Books Table Data:");

		while (rs.next()) {

//			int id = rs.getInt("id");
//			String name = rs.getString("name");
//			double price = rs.getDouble("price");
			
//			System.out.println(id + "  " + name + "  " + price);
			
			int type = rs.getInt("price_type");
			int count = rs.getInt("total");

			System.out.println(type + " " + count);
		}
		
		con.close();
	}
}