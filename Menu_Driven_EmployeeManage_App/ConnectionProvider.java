package com.student_management_system.demo_student_management_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	 static Connection con;
	  
	  public static Connection createC() {
		  try {
			  // load the driver
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  
			  // create the connection
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sayanndb", "root", "SAYANdas1@");
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		return con;
		  
	  }

}
