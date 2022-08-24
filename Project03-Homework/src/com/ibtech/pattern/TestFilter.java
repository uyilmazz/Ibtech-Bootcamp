package com.ibtech.pattern;

import java.util.List;

public class TestFilter {
	public static void main(String[] args) throws Exception {
		
		CustomerManager customerManager = new CustomerManager();		
		String cutomerNamePattern = "ay";
		List<Customer> customerList = customerManager.listByCustomerNameLike(cutomerNamePattern);
		for (Customer customer : customerList) {
			System.out.println(
					customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
		}
	}
}
