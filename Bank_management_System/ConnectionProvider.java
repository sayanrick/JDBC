package com.bank_management_app;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	 static Connection con;
	  
	  public static Connection createC() {
		  try {
			  // load the driver
			  Class.forName("com.mysql.cj.jdbc.Driver");
			  
			  // create the connection
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_manage", "root", "SAYANdas1@");
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		return con;
	  }
}
