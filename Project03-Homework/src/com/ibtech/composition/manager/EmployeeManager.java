package com.ibtech.composition.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.ibtech.composition.entity.Employee;


public class EmployeeManager extends BaseManager<Employee> {

	public List<Employee> listAll() throws SQLException{
		String sql = "Select * from employee";
		return super.listAll(sql);
	}

	public Employee find(long id) throws SQLException {
		String sql = "Select * from employee where employeeid = ?";
		return super.find(sql, id);
	}
	
	@Override
	protected Employee parse(ResultSet resultSet) throws SQLException {
		long employeeId = resultSet.getLong("employeeId");
		String employeeName = resultSet.getString("employeeName");
		double monthlySalary = resultSet.getDouble("monthlySalary");
		Employee employee = new Employee(employeeId, employeeName, monthlySalary);
		return employee;
	}

}
