package com.ibtecth.sales;

public class CustomerTest2 {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setCustomerId(501);
		customer.setCustomerName("Neşet Ertaş");
		customer.setTotalDebit(4350);
		
		System.out.println(customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
	}
}
