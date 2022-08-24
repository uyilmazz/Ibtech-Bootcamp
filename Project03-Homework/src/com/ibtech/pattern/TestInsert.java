package com.ibtech.pattern;

public class TestInsert {

	public static void main(String[] args) {

		try {
			CustomerManager customerManager = new CustomerManager();
			Customer customer = new Customer(0,"Erkan Ocaklı",7560);
			boolean inserted = customerManager.insert(customer);
			if (inserted) {
				System.out.println("Müşteri sokuldu.");
			} else {
				System.out.println("Müşteri sokulamadı");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
