package com.ibtech.sports.database.manager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ibtech.sports.database.entity.Player;

public class PlayerManager extends BaseManager<Player>{

	public Player find(long playerId) throws SQLException {
		String sql = "Select * from players where playerId = ?";
		return super.find(sql, playerId);
	}
	
	public Player findByName(String playerName) throws SQLException {
		Player player = null;
		String sql = "Select * from players where playerName = ?";
		connect();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1,playerName);
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()) {
			player = parse(resultSet);
		}
		disconnect();
		return player;
	}
	
	public List<Player> list() throws SQLException {
		String sql = "Select * from players";
		return super.listAll(sql);
	}

	public boolean insert(Player player) throws SQLException {
		Player dbPlayer = findByName(player.getPlayerName());
		if(dbPlayer != null) {
			return false;
		}
		connect();		
		String sql = "insert into players(playerName,averageScore) values(?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, player.getPlayerName());
		statement.setDouble(2, player.getAverageScore());
		int affected = statement.executeUpdate();
		disconnect();
		return affected > 0 ? true : false;
	}

	public boolean update(Player player) throws SQLException {
		Player dbPlayer = find(player.getPlayerId());
		if(dbPlayer == null) {
			return false;
		}
		connect();	
		String sql = "Update players set playerName=?,averageScore=? where playerId=?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, player.getPlayerName());
		statement.setDouble(2, player.getAverageScore());
		statement.setLong(3, player.getPlayerId());
		int affected = statement.executeUpdate();
		disconnect();
		return affected > 0 ? true : false;
	}

	public boolean delete(long playerId) throws SQLException {
		Player dbPlayer = find(playerId);
		if(dbPlayer == null) {
			return false;
		}
		String sql = "Delete from players where playerId=?";
		return super.delete(sql, playerId);
	}

	@Override
	protected Player parse(ResultSet resultSet) throws SQLException {
		Long playerId = resultSet.getLong("playerId");
		String playerName = resultSet.getString("playerName");
		double averageScore = resultSet.getDouble("averageScore");
		Player player = new Player(playerId,playerName,averageScore);
		return player;
	}
}
