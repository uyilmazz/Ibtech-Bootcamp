package com.ibtech.accountConverter;

public class AccountConverterTest {

	public static void main(String[] args) {
		
		String line="601;Kasa Hesabı;23560";
		Account account = AccountConverter.parse(line);
		System.out.println(account.getAccountId() + " "  + account.getAccountName() + " " + account.getAmountLocal());
		
		String string = AccountConverter.format(account);
		System.out.println(string);
	}
	
	
}
