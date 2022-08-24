package com.ibtech.pattern;

public class TestDelete {

	public static void main(String[] args) {
		try {
			CustomerManager customerManager = new CustomerManager();
			boolean deleted = customerManager.delete(5);
			if (deleted) {
				System.out.println("Silindi..");
			} else {
				System.out.println("Silinemedi.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
