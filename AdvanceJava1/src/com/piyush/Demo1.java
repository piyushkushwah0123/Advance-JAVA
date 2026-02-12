package com.piyush;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {

	private static final String DBURL = "jdbc:mysql://localhost:3306/regex2";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "root";

	// private static final String INSERTSQL = "INSERT INTO regex2
	// VALUES(3,'john','jaipur')";

	public static final String SELECTSQL = "select * from regex2";

	public static void main(String[] args) throws Exception {

		// 1.Load the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2. Get the connection
		Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);

		// 3. Create statement
		Statement stmt = con.createStatement();

		// 4. Execute and process the result
		// int rowsaffected = stmt.executeUpdate(INSERTSQL);
		// System.out.println("Rows Inserted: " + rowsaffected);

		ResultSet rs = stmt.executeQuery(SELECTSQL);
		if (rs.next()) {
			int studentID = rs.getInt(1);
			String studentName = rs.getString(2);
			String studentAddress = rs.getString(3);

			System.out.println(studentID + " " + studentName + " " + studentAddress);
		}

		// 5. Close the connection
		con.close();

	}
}
