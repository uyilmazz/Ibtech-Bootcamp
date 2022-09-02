package com.ibtech.sports.database.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibtech.sports.database.entity.Player;

public abstract class BaseManager<E> {

	private String url = "jdbc:postgresql://localhost/dbgodoro";
	private String user = "postgres";
	private String password = "12345";
	private String driver = "org.postgresql.Driver";

	protected Connection connection;

	public BaseManager() {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void connect() throws SQLException {
		connection = DriverManager.getConnection(url, user, password);
	}

	protected void disconnect() throws SQLException {
		if (connection != null) {
			connection.close();
		}
	}
	
	public List<E> listAll(String sql) throws SQLException {
		connect();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		List<E> entityList = parseList(resultSet);
		disconnect();
		return entityList;
	}
	
	public E find(String sql,long id) throws SQLException {
		E entity = null;
		connect();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1, id);
		ResultSet resultSet = statement.executeQuery();
		if (resultSet.next()) {
			entity = parse(resultSet);
		}
		disconnect();
		return entity;
	}
	
	public boolean delete(String sql,long id) throws SQLException {
		connect();	
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setLong(1,id);
		int affected = statement.executeUpdate();
		disconnect();
		return affected > 0 ? true : false;
	}
	

	protected List<E> parseList(ResultSet resultSet) throws SQLException {
		List<E> entityList = new ArrayList<>();
		while (resultSet.next()) {
			E entity = parse(resultSet);
			entityList.add(entity);
		}
		return entityList;
	}

	protected abstract E parse(ResultSet resultSet) throws SQLException;
}
