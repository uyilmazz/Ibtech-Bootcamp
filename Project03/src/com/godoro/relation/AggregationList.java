package com.godoro.relation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AggregationList {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:postgresql://localhost/dbgodoro";
		String user = "postgres";
		String password = "12345";

		String driver = "org.postgresql.Driver";
		Class.forName(driver);

		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "select e.departmentid, d.departmentname,sum(monthlysalary) as salarysum from employee e\r\n"
				+ "right join department d on e.employeeid = d.departmentid \r\n"
				+ "group by e.departmentid, d.departmentname  ";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			long departmentId = resultSet.getLong("departmentid");
			double salarySum = resultSet.getDouble("salarysum");
			String departmentName = resultSet.getString("departmentName");
			System.out.println(departmentId + " " + departmentName + " " + salarySum);
		}

		connection.close();

	}

}
