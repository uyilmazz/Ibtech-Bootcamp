package com.godoro.composition.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.godoro.composition.entity.Employee;

public class EmployeeManager extends BaseManager<Employee> {

	public List<Employee> listAll() throws SQLException {
		connect();
		String sql = "Select * from employee";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Employee> employeeList = parseList(resultSet);

		disconnect();
		return employeeList;
	}

	public Employee find(long id) throws SQLException {
		Employee employee = null;
		connect();
		String sql = "Select * from Employee where employeeId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			employee = parse(resultSet);
		}

		disconnect();
		return employee;
	}

	@Override
	protected Employee parse(ResultSet resultSet) throws SQLException {
		long employeeId = resultSet.getLong("employeeId");
		String employeeName = resultSet.getString("employeeName");
		double monthlySales = resultSet.getDouble("monthlySales");
		Employee employee = new Employee(employeeId, employeeName, monthlySales);
		return employee;
	}

}
