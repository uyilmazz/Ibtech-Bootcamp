package com.ibtech.transaction.client;

import java.io.IOException;

import com.ibtech.transaction.entity.Transaction;
import com.ibtech.transaction.utils.StreamUtilities;
import com.ibtech.transaction.utils.TransactionConverter;

public class GetClient {

	public static void main(String[] args) throws IOException {
		
		String address = "http://localhost:8080/Project04-Homework/get";
		String text = StreamUtilities.get(address);
		Transaction transaction = TransactionConverter.parse(text);
		System.out.println(transaction.getTransactionId() + " " + transaction.getTransactionName() + " " + transaction.getAmountLocal());
	}
}
