package com.ibtech.pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {

	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String user = "postgres";
	private String password = "12345";

	private String driver = "org.postgresql.Driver";

	public CustomerManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean insert(Customer customer) throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Insert into Customers(customer_name,total_debit) values (?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalDebit());
		int affected = statement.executeUpdate();

		connection.close();
		System.out.println("Etkileniş" + affected);
		return affected > 0;
	}

	public boolean update(Customer customer) throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Update Customers set customer_name = ? , total_debit = ? where customer_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, customer.getCustomerName());
		statement.setDouble(2, customer.getTotalDebit());
		statement.setLong(3, customer.getCustomerId());
		int affected = statement.executeUpdate();

		connection.close();
		return affected > 0;
	}
	
	public List<Customer> listByTotalDebitGreater(double totalDebitMin) throws SQLException{
		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "Select * from Customers where total_debit >= ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setDouble(1, totalDebitMin);
		ResultSet resultSet = statement.executeQuery();

		List<Customer> CustomerList = parseList(resultSet);
		connection.close();
		return CustomerList;
	}
	
	public List<Customer> listByCustomerNameLike(String customerNamePattern) throws SQLException{
		Connection connection = DriverManager.getConnection(url, user, password);

		String sql = "Select * from Customers where customer_name like ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, "%"+customerNamePattern+"%");
		ResultSet resultSet = statement.executeQuery();

		List<Customer> CustomerList = parseList(resultSet);
		connection.close();
		return CustomerList;
	}

	public boolean delete(long customerId) throws SQLException {

		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Delete from Customers where customer_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, customerId);
		int affected = statement.executeUpdate();

		connection.close();
		return affected > 0;
	}

	public List<Customer> listAll() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Select * from Customers";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<Customer> customerList = parseList(resultSet);

		connection.close();
		return customerList;
	}

	public Customer find(long id) throws SQLException {
		Customer customer = null;
		Connection connection = DriverManager.getConnection(url, user, password);
		String sql = "Select * from Customers where customer_id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);

		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			customer = parse(resultSet);
		}

		connection.close();
		return customer;
	}

	private List<Customer> parseList(ResultSet resultSet) throws SQLException {
		List<Customer> customerList = new ArrayList<>();
		while (resultSet.next()) {
			Customer customer = parse(resultSet);
			customerList.add(customer);
		}
		return customerList;
	}

	private Customer parse(ResultSet resultSet) throws SQLException {
		long customerId = resultSet.getLong("customer_id");
		String customerName = resultSet.getString("customer_name");
		double totalDebit = resultSet.getDouble("total_debit");
		Customer customer = new Customer(customerId, customerName, totalDebit);
		return customer;
	}

}
