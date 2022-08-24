package com.ibtech.filer;

import java.util.List;

public class TestLoad {

	public static void main(String[] args) {
		
		String filePathSupplier = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Supplier.txt";
		String filePathCustomer = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Customer.txt";
		try {
			SupplierFiler supplierFiler = new SupplierFiler(filePathSupplier);
			CustomerFiler customerFiler = new CustomerFiler(filePathCustomer);
			List<Supplier> supplierList = supplierFiler.load();
			List<Customer> customerList = customerFiler.load();
			System.out.println("******** Supplier List *********");
			for(Supplier supplier : supplierList) {
				System.out.println(supplier.getSupplierId() + " " + supplier.getSupplierName() + " " + supplier.getTotalCredit());
			}
			
			System.out.println("******** Customer List *********");
			for(Customer customer : customerList) {
				System.out.println(customer.getCustomerId() + " " + customer.getCustomerName() + " " + customer.getTotalDebit());
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
