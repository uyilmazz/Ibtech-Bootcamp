package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public static void main(String[] args) throws Exception {
			
		String url = "jdbc:postgresql://localhost/Northwind";
		String user = "postgres";
		String password = "12345";
		
		String driver = "org.postgresql.Driver";
		Class.forName(driver);
			
		Connection connection = DriverManager.getConnection(url, user,password);
			
		System.out.println(connection.getMetaData().getDatabaseProductName());
		
		connection.close();
	
	}
}
