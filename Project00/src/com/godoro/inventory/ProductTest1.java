package com.godoro.inventory;

public class ProductTest1 {
	public static void main(String[] args) {
		Product product = new Product(501,"Cep Telefonu",1300);
		System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
	}
}
