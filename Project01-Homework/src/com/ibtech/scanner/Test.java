package com.ibtech.scanner;

import java.util.Formatter;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Account account = new Account();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Account Id: ");
		long accountId = Long.parseLong(scanner.nextLine());
		account.setAccountId(accountId);
		
		System.out.println("Account Name: ");
		String accountName = scanner.nextLine();
		account.setAccountName(accountName);
		
		System.out.println("Amount Local: ");
		double amountLocal = scanner.nextDouble();
		account.setAmountLocal(amountLocal);
		scanner.close();
		
		System.out.printf("AccountId: %3d Account Name: %-5s Amount Local: %7.2f\n",account.getAccountId(),account.getAccountName(),account.getAmountLocal());
		
		Formatter formatter = new Formatter(System.out);
		formatter.format("AccountId: %3d Account Name: %-5s Amount Local: %7.2f\n", account.getAccountId(),account.getAccountName(),account.getAmountLocal());
		formatter.close();
	}
}
