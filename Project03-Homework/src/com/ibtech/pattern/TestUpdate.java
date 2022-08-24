package com.ibtech.pattern;

public class TestUpdate {

	public static void main(String[] args) {
		try {
			CustomerManager customerManager = new CustomerManager();
			Customer customer = new Customer(3,"Ferdi Tayfur",3500);
			boolean updated = customerManager.update(customer);
			if (updated) {
				System.out.println("Güncellendi.");
			} else {
				System.out.println("Güncellenemedi!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
