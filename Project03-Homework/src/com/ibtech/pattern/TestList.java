package com.ibtech.pattern;

import java.util.List;

public class TestList {
	public static void main(String[] args) {

		try {
			CustomerManager customerManager = new CustomerManager();
			List<Customer> customerList = customerManager.listAll();
			for (Customer customer : customerList) {
				System.out.println(
						customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
