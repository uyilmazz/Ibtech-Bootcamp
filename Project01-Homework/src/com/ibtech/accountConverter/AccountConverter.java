package com.ibtech.accountConverter;

public class AccountConverter {
	
	public static Account parse(String line) {
		String[] tokens = line.split(";");
		Account account = new Account();
		account.setAccountId(Long.parseLong(tokens[0]));
		account.setAccountName(tokens[1]);
		account.setAmountLocal(Double.parseDouble(tokens[2]));
		return account;
	}
	
	public static String format(Account account) {
		StringBuilder builder = new StringBuilder();
		builder.append(account.getAccountId()).append(";")
		.append(account.getAccountName()).append(";")
		.append(account.getAmountLocal());
		
		return builder.toString();
	}
}
