package com.godoro.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestUpdate {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:postgresql://localhost/dbgodoro";
		String user = "postgres";
		String password = "12345";

		String driver = "org.postgresql.Driver";
		Class.forName(driver);

		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "Update  Product set productName = ? , salesPrice = ? where productId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "Tablet Bilgisayar");
		statement.setDouble(2, 7645);
		statement.setLong(3, 2);
		int affected = statement.executeUpdate();

		connection.close();

		System.out.println("Etkilenmiş " + affected);
	}

}
