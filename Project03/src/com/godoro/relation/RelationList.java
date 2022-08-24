package com.godoro.relation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RelationList {

	
public static void main(String[] args) throws Exception {
		
		String url = "jdbc:postgresql://localhost/dbgodoro";
		String user = "postgres";
		String password = "12345";
		
		String driver = "org.postgresql.Driver";
		Class.forName(driver);
			
		Connection connection = DriverManager.getConnection(url, user,password);
			
		String sql = "select * from employee e\r\n"
				+ "left join department d on e.employeeid = d.departmentid ";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		
		while(resultSet.next()) {
			long employeeId = resultSet.getLong("employeeid");
			String employeeName = resultSet.getString("employeename");
			double monthlysalary = resultSet.getDouble("monthlysalary");
			String departmentName = resultSet.getString("departmentName");
			long departmentId = resultSet.getLong("departmentId");
			System.out.println(employeeId + " " + employeeName + " " + monthlysalary + " " + departmentId +  " " + departmentName);
		}
		
		connection.close();

	}

}
