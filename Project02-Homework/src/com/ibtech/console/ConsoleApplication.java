package com.ibtech.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {

	private static String filePath = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\Supplier.txt";
	private static Scanner scanner = new Scanner(System.in);
	private static List<Supplier> supplierList = new ArrayList<>();
	private static SupplierFiler supplierFiler = new SupplierFiler(filePath);

	private static void printMenu() {
		System.out.println("Menu");
		System.out.println("1. Yükle");
		System.out.println("2. Sakla");
		System.out.println("3. Dizelgele");
		System.out.println("4. Bul");
		System.out.println("5. Ekle");
		System.out.println("6. Güncelle");
		System.out.println("7. Sil");
		System.out.println("0. Çıkış");
	}

	private static int scanChoice() {
		System.out.println("Seçiniz:");
		int choice = scanner.nextInt();
		System.out.println("Seçilen: " + choice);
		return choice;
	}

	private static void doExit() {
		System.exit(0);
	}

	private static void doLoad() {
		try {
			supplierList = supplierFiler.load();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void doStore() {
		try {
			supplierFiler.store(supplierList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void doList() {
		for (Supplier supplier : supplierList) {
			System.out.println(
					supplier.getSupplierId() + " " + supplier.getSupplierName() + " " + supplier.getTotalCredit());
		}
	}

	private static void doFind() {
		System.out.println("supplier id : ");
		long supplierId = scanner.nextLong();
		int index = getIndex(supplierId);
		if (index < 0) {
			System.out.println("Satımcı bulunamadı: " + supplierId);
		} else {
			Supplier supplier = supplierList.get(index);
			System.out.println(
					supplier.getSupplierId() + " " + supplier.getSupplierName() + " " + supplier.getTotalCredit());
		}
	}

	private static void doAdd() {
		Supplier newSupplier = createSupplierFromConsole();
		supplierList.add(newSupplier);
		doStore();
	}

	private static Supplier createSupplierFromConsole() {
		System.out.println("Supplier id: ");
		long supplierId = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Supplier name: ");
		String supplierName = scanner.nextLine();
		System.out.println("Total credit: ");
		double totalCredit = Double.parseDouble(scanner.nextLine());
		Supplier supplier = new Supplier(supplierId, supplierName, totalCredit);
		return supplier;
	}

	private static int getIndex(long supplierId) {
		for (int i = 0; i < supplierList.size(); i++) {
			if (supplierId == supplierList.get(i).getSupplierId()) {
				return i;
			}
		}
		return -1;
	}

	private static void doUpdate() {
		System.out.println("Supplier id: ");
		long supplierId = scanner.nextLong();
		int index = getIndex(supplierId);
		if (index < 0) {
			System.out.println("Satımcı bulunamadı: " + supplierId);
		} else {
			Supplier updatedSupplier = createSupplierFromConsole();
			supplierList.set(index, updatedSupplier);
		}
	}

	private static void doDelete() {
		System.out.println("Supplier id: ");
		long supplierId = scanner.nextLong();
		int index = getIndex(supplierId);
		if (index < 0) {
			System.out.println("Satımcı bulunamadı: " + supplierId);
		} else {
			supplierList.remove(index);
		}
	}

	private static void handleChoice(int choice) {
		switch (choice) {
		case 0:
			doExit();
			break;
		case 1:
			doLoad();
			break;
		case 2:
			doStore();
			break;
		case 3:
			doList();
			break;
		case 4:
			doFind();
			break;
		case 5:
			doAdd();
			break;
		case 6:
			doUpdate();
			break;
		case 7:
			doDelete();
			break;
		default:
			System.out.println("Geçersiz seçim : " + choice);
		}
	}

	public static void main(String[] args) {

		while (true) {
			printMenu();
			int choice = scanChoice();
			handleChoice(choice);
		}
	}
}
