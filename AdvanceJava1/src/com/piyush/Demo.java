package com.piyush;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo {

	private static final String DBURL = "jdbc:mysql://localhost:3306/piyush";
	private static final String DBUSERNAME  = "root";
	private static final String DBPASSWORD = "root";
	private static final String INSERTDATA = "insert into student values(?,?,?)";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
				Class.forName("com.mysql.cj.jdbc.Driver");
				
		        Connection con = DriverManager.getConnection(DBURL, DBUSERNAME, DBPASSWORD); 			
				
		        PreparedStatement pstmt = con.prepareStatement(INSERTDATA);
		        System.out.println(" Enter the Studnet ID ");
		        Scanner sc = new Scanner(System.in);
		                int id = sc.nextInt();      
		        System.out.println(" Enter the Studnet Name ");        
		        String name = sc.next();
		        System.out.println(" Enter the Studnet City ");        
		        String city = sc.next();
		        	        
		        pstmt.setInt(1,id);
		        pstmt.setString(2,name);
		        pstmt.setString(3,city);
		        
		       int rowsaffected = pstmt.executeUpdate();
		        
		       System.out.println("Rows affected"+ rowsaffected );
		       con.close();
		       
	}
}
