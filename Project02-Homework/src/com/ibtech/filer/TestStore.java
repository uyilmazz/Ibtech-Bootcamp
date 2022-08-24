package com.ibtech.filer;

import java.util.ArrayList;
import java.util.List;

public class TestStore {

	public static void main(String[] args) {
		
		String filePathSupplier = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Supplier.txt";
		String filePathCustomer = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Customer.txt";
		
		try {
			List<Supplier> supplierList = new ArrayList<>();
			supplierList.add(new Supplier(601,"Cem Karaca",6540));
			supplierList.add(new Supplier(602,"Barış Manço",7645));
			supplierList.add(new Supplier(603,"Fikret Kızılok",3450));
			
			List<Customer> customerList = new ArrayList<>();
			customerList.add(new Customer(601,"Cem Karaca",6540));
			customerList.add(new Customer(602,"Barış Manço",7645));
			customerList.add(new Customer(603,"Fikret Kızılok",3450));
			
			SupplierFiler supplierFiler = new SupplierFiler(filePathSupplier);
			CustomerFiler customerFiler = new CustomerFiler(filePathCustomer);
			supplierFiler.store(supplierList);
			customerFiler.store(customerList);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
