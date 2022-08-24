package com.godoro.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String user = "postgres";
	private String password = "12345";

	private String driver = "org.postgresql.Driver";

	public ProductManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean insert(Product product) throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Insert into Product(productName,salesPrice) values (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalesPrice());
		int affected = statement.executeUpdate();

		connection.close();
		System.out.println("Etkileniş" + affected);
		return affected > 0;
	}

	public boolean update(Product product) throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Update  Product set productName = ? , salesPrice = ? where productId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, product.getProductName());
		statement.setDouble(2, product.getSalesPrice());
		statement.setLong(3, product.getProductId());
		int affected = statement.executeUpdate();

		connection.close();
		return affected > 0;
	}
	
	public List<Product> listBySalesPriceGreater(double salesPriceMin) throws SQLException{
		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "Select * from product where salesPrice >= ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, salesPriceMin);
		ResultSet resultSet = statement.executeQuery();

		List<Product> productList = parseList(resultSet);
		connection.close();
		return productList;
	}
	
	public List<Product> listByProductNameLike(String productNamePattern) throws SQLException{
		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "Select * from product where productName like ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "%"+productNamePattern+"%");
		ResultSet resultSet = statement.executeQuery();

		List<Product> productList = parseList(resultSet);
		connection.close();
		return productList;
	}

	public boolean delete(long productId) throws SQLException {

		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Delete from Product where productId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, productId);
		int affected = statement.executeUpdate();

		connection.close();
		return affected > 0;
	}

	public List<Product> listAll() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Select * from product";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Product> productList = parseList(resultSet);

		connection.close();
		return productList;
	}

	public Product find(long id) throws SQLException {
		Product product = null;
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Select * from product where productId = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			product = parse(resultSet);
		}

		connection.close();
		return product;
	}

	private List<Product> parseList(ResultSet resultSet) throws SQLException {
		List<Product> productList = new ArrayList<>();
		while (resultSet.next()) {
			Product product = parse(resultSet);
			productList.add(product);
		}
		return productList;
	}

	private Product parse(ResultSet resultSet) throws SQLException {
		long productId = resultSet.getLong("productId");
		String productName = resultSet.getString("productName");
		double salesPrice = resultSet.getDouble("salesPrice");
		Product product = new Product(productId, productName, salesPrice);
		return product;
	}

}
