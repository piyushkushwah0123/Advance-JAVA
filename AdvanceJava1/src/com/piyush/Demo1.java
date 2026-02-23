package com.piyush;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo1 {

	private static final String DBURL = "jdbc:mysql://localhost:3306/regex2";
	private static final String DBUSERNAME = "root";
	private static final String DBPASSWORD = "root";
	public static final String SELECTSQL = "select * from regex2";
	private static final String INSERTSQL = "???";

	public static void main(String[] args) throws Exception {
			
		Class.forName("com.mysql.cj.jdbc.Driver"); // 1.Load the Driver

		Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD); // 2. Get the connection

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter student id:");
		int id = sc.nextInt();
		sc.nextInt();
		
		System.out.println("Enter student name:");
		String name = sc.nextLine();
		sc.nextLine();
		
		System.out.println("Enter student address:");
		String address = sc.nextLine();
		sc.nextLine();
		
		PreparedStatement ps = con.prepareStatement(INSERTSQL);
		ps.setInt(1,id);
		ps.setString(2,name);
		ps.setString(3, address);
        
		ResultSet rs = ps.executeQuery(SELECTSQL);
		while (rs.next()) {
			int studentID = rs.getInt(1);
			String studentName = rs.getString(2);
			String studentAddress = rs.getString(3);
			System.out.println(studentID + " " + studentName + " " + studentAddress);
		}
		con.close();// 5. Close the connection
	}
}
