package com.ibtech.composition.console;

import java.util.List;

import com.ibtech.composition.entity.Department;
import com.ibtech.composition.manager.DepartmentManager;

public class TestDepartmentList {
	public static void main(String[] args) {
		try {
			DepartmentManager departmentManager = new DepartmentManager();
			List<Department> departmentList = departmentManager.listAll();
			
			for (Department department : departmentList) {
				System.out.println(department.getDepartmentId() +" " + department.getDepartmentName());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
