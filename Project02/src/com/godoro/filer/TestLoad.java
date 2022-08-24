package com.godoro.filer;

import java.io.IOException;
import java.util.List;

public class TestLoad {
	public static void main(String[] args) throws IOException {

		String filePath = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Supplier.txt";

		SupplierFiler supplierfiler = new SupplierFiler(filePath);
		List<Supplier> supplierList = supplierfiler.load();

		for (Supplier supplier : supplierList) {
			System.out.println(
					supplier.getSupplierId() + " " + supplier.getSupplierName() + " " + supplier.getTotalCredit());
		}

	}
}
