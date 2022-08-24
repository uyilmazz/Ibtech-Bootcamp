package com.godoro.pattern;

public class TestDelete {

	public static void main(String[] args) {
		try {
			ProductManager productManager = new ProductManager();
			boolean deleted = productManager.delete(5);
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
