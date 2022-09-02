package com.ibtech.transaction.utils;

import com.ibtech.transaction.entity.Transaction;

public class TransactionConverter {

	private static String DELIMETER = ";";
	
	public static Transaction parse(String line) {
		String[] tokens = line.split(DELIMETER);
		Transaction transaction = new Transaction();
		transaction.setTransactionId(Long.parseLong(tokens[0]));
		transaction.setTransactionName(tokens[1]);
		transaction.setAmountLocal(Double.parseDouble(tokens[2]));
		return transaction;
	}
	
	public static String format(Transaction transaction) {
		StringBuilder builder = new StringBuilder();
		builder.append(transaction.getTransactionId()).append(DELIMETER)
		.append(transaction.getTransactionName()).append(DELIMETER)
		.append(transaction.getAmountLocal());
		return builder.toString();
	}
}
