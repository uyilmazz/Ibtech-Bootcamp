package com.godoro.pattern;

import java.util.List;

public class TestList {
	public static void main(String[] args) {

		try {
			ProductManager productManager = new ProductManager();
			List<Product> productList = productManager.listAll();
			for (Product product : productList) {
				System.out.println(
						product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
