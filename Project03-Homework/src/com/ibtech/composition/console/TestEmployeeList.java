package com.ibtech.composition.console;

import java.util.List;

import com.ibtech.composition.entity.Employee;
import com.ibtech.composition.manager.EmployeeManager;

public class TestEmployeeList {
	public static void main(String[] args) {
		try {
			EmployeeManager employeeManager = new EmployeeManager();
			List<Employee> employeeList = employeeManager.listAll();
			
			for (Employee employee : employeeList) {
				System.out.println(employee.getEmployeeId() +" " + employee.getEmployeeName() + " " + employee.getMontlySalary());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
