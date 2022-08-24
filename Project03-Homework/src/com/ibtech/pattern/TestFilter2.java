package com.ibtech.pattern;

import java.util.List;

public class TestFilter2 {
	public static void main(String[] args) throws Exception {

		CustomerManager customerManager = new CustomerManager();
		double totalDebit = 5000;
		List<Customer> customerList = customerManager.listByTotalDebitGreater(totalDebit);
		for (Customer customer : customerList) {
			System.out.println(
					customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
		}
	}
}
