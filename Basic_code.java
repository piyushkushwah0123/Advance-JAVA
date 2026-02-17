package com.piyush;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Basic_code {

	private static final String DBURL = "jdbc:mysql://localhost:3306/java";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "root";
	private static final String INSERTDATA = "insert into user values(1, 'Piyush', 'Jaipur')";
	
	public static void main(String[] args) throws Exception {
		
		// 1.Load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// 2. Get the connection :- It is an Interface in java
		Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD); 
		
		//3. Create the Statement 
		Statement stmt = con.createStatement();
		
		int rowsaffected = stmt.executeUpdate(INSERTDATA);
		System.out.println(rowsaffected + " rows affected");
		System.out.println("Successfully executed");
		
		// 5. Close the Connection 
		con.close();
		
	}
}
