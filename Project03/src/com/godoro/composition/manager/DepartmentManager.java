package com.godoro.composition.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.godoro.composition.entity.Department;

public class DepartmentManager extends BaseManager <Department>{

	public List<Department> listAll() throws SQLException {
		connect();
		String sql = "Select * from department";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Department> departmentList = parseList(resultSet);

		disconnect();
		return departmentList;
	}

	public Department find(long id) throws SQLException {
		Department department = null;
		connect();
		String sql = "Select * from deparment where departmentId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			department = parse(resultSet);
		}

		disconnect();
		return department;
	}

	@Override
	protected Department parse(ResultSet resultSet) throws SQLException {
		long departmentId = resultSet.getLong("employeeId");
		String departmentName = resultSet.getString("employeeName");
		Department department = new Department(departmentId, departmentName);
		return department;
	}
}
