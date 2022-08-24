package com.ibtech.pattern;

public class TestFind {

	public static void main(String[] args) {

		try {
			CustomerManager customerManager = new CustomerManager();
			long customerId = 3;
			Customer customer = customerManager.find(customerId);
			if (customer != null) {
				System.out.println(
						customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
