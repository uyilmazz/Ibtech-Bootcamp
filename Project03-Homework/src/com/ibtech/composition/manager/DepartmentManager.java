package com.ibtech.composition.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ibtech.composition.entity.Department;


public class DepartmentManager extends BaseManager <Department>{

	public List<Department> listAll() throws SQLException{
		String sql = "Select * from department";
		return super.listAll(sql);
	}

	public Department find(long id) throws SQLException {
		String sql = "Select * from department where departmentid = ?";
		return super.find(sql, id);
	}
	
	@Override
	protected Department parse(ResultSet resultSet) throws SQLException {
		long departmentId = resultSet.getLong("departmentId");
		String departmentName = resultSet.getString("departmentName");
		Department department = new Department(departmentId, departmentName);
		return department;
	}
}
