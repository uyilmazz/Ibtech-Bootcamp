package com.ibtech.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserManager {
	
	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String dbUser = "postgres";
	private String password = "12345";
	private String driver = "org.postgresql.Driver";

	private Connection connection;

	public UserManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void connect() throws SQLException {
		connection = DriverManager.getConnection(url, dbUser, password);
	}
	
	private void disconnect() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
	
	public User findByUserName(String userName) throws SQLException {
		User user = null;
		connect();
		String sql = "Select * from users where username=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, userName);
		ResultSet resultSet = statement.executeQuery();
		
		if(resultSet.next()) {
			user = parse(resultSet);
		}
		
		disconnect();
		return user;
	}
	
	public User parse(ResultSet resultSet) throws SQLException {
		Long userId = resultSet.getLong("userid");
		String username = resultSet.getString("username");
		String password = resultSet.getString("password");
		User user = new User(userId,username,password);
		return user;
	}
	
	public Map<String,Object> create(User user) throws SQLException {
		User dbUser = findByUserName(user.getUsername());
		connect();
		if(dbUser != null ) {
			return result(false,"User zaten mevcut!");
		}
		
		String sql = "insert into users(username,password) values(?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		int affected = statement.executeUpdate();
		if(affected > 0) {
			return result(true,"User eklendi.");
		}
		disconnect();
		return result(false,"Bir hata oluştu.");
	}
	
	private Map<String,Object> result(boolean success,String message){
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("success", success);
		result.put("message", message);
		return result;
	}
	
}
