package com.godoro.pattern;

public class TestUpdate {

	public static void main(String[] args) {
		try {
			ProductManager productManager = new ProductManager();
			Product product = new Product(4,"Mikser",450);
			boolean updated = productManager.update(product);
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
