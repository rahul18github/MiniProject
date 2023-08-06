package com.project.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionEstablish {
	
	public static Connection getconnection(){
		
		Connection connection=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}

}
