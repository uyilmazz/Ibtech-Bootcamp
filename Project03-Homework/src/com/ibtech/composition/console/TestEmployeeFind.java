package com.ibtech.composition.console;

import com.ibtech.composition.entity.Employee;
import com.ibtech.composition.manager.EmployeeManager;

public class TestEmployeeFind {
	public static void main(String[] args) {
		try {
			EmployeeManager employeeManager = new EmployeeManager();
			long employeeId = 3;
			Employee employee = employeeManager.find(employeeId);
			if(employee != null) {
				System.out.println(employee.getEmployeeId() +" " + employee.getEmployeeName() + " " + employee.getMontlySalary());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
