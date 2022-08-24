package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TransactionTest {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:postgresql://localhost/dbgodoro";
		String user = "postgres";
		String password = "12345";

		String driver = "org.postgresql.Driver";
		Class.forName(driver);

		Connection connection = DriverManager.getConnection(url, user, password);

		connection.setAutoCommit(false);
		String sql = "Insert into Product(productName,salesPrice) values (?,?)";
		PreparedStatement statement1 = connection.prepareStatement(sql);
		statement1.setString(1, "Ürün 101");
		statement1.setDouble(2, 3010);
		int affected1 = statement1.executeUpdate();

		PreparedStatement statement2 = connection.prepareStatement(sql);
		statement2.setString(1, "Ürün 102");
		statement2.setDouble(2, 3020);
		int affected2 = statement2.executeUpdate();

		PreparedStatement statement3 = connection.prepareStatement("X" + sql + "X");
		statement3.setString(1, "Ürün 103");
		statement3.setDouble(2, 3020);
		int affected3 = statement3.executeUpdate();

		connection.commit();
		connection.close();

		System.out.println("Etkilenmiş " + affected1 + " " + affected2 + " " + affected3);
	}
}
