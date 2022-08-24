package com.godoro.collections;

import com.godoro.inventory.Product;

public class ProductsTest {
	public static void main(String[] args) {
		Product[] products = {
				new Product(501,"Cep Telefonu",1300.0),
				new Product(502,"Masaüstü Bilgisayar",6540.0),
				new Product(503,"Dizüstü Bilgisayar",7865.0),
		};
		
		for (Product product : products) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
		}
		
		double priceSum = 0;
		int count = 0;
		for (Product product : products) {
			if(product.getSalesPrice() > 5000) {
				priceSum += product.getSalesPrice();
				count ++;
			}
		}
		
		System.out.println("Eder Özetim: " + priceSum);
		double averagePrice = priceSum / count;
		System.out.println("Eder Ortalama: " + averagePrice);
	
	}
}
