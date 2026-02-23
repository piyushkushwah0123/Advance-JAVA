package com.piyush;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo12 {

	private static final String DBURL = "jdbc:mysql://localhost:3306/java";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "root";
	private static final String SQLQUERY = "call p2(?)";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1.Load the Driver
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				// 2. Get the connection :- It is an Interface in java
				Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD);
				
				
				// Passing value to IN parameter
				CallableStatement cstmt = con.prepareCall("call p2(?)");
				cstmt.setInt(1, 2);

				
				ResultSet rs = cstmt.executeQuery();

				while(rs.next()) {
				    System.out.println(rs.getInt(1) + " " 
				        + rs.getString(2) + " " 
				        + rs.getString(3));
				}
				
	}
}
