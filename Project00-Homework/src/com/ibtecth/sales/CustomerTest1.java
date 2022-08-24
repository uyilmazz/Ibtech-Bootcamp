package com.ibtecth.sales;

public class CustomerTest1 {
	public static void main(String[] args) {
		
		Customer customer = new Customer(501,"Neşet Ertaş",4350);
		System.out.println("Müşteri Özdeşliği: " + customer.getCustomerId());
		System.out.println("Müşteri Adı: " + customer.getCustomerName());
		System.out.println("Toplam Borç: " + customer.getTotalDebit());
	}
}
