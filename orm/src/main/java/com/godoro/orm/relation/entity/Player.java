package com.godoro.orm.relation.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Player {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playerId;
	
	private String playerName;
	
	private double averageScore;
	
	@ManyToOne
	@JoinColumn(name="teamId")
	private Team team;
	
	public Player() {
	}
	public Player(long playerId, String playerName, double averageScore) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.averageScore = averageScore;
	}
	public long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public double getAverageScore() {
		return averageScore;
	}
	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
}
