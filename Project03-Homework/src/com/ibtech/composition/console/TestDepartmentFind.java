package com.ibtech.composition.console;

import com.ibtech.composition.entity.Department;
import com.ibtech.composition.manager.DepartmentManager;

public class TestDepartmentFind {
	public static void main(String[] args) {
		try {
			DepartmentManager departmentManager = new DepartmentManager();
			long departmentId = 3;
			Department department = departmentManager.find(departmentId);
			if(department != null) {
				System.out.println(department.getDepartmentId() +" " + department.getDepartmentName());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
