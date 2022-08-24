package com.ibtech.league;

import java.util.List;

public class Team {
	private long teamId;
	private String teamName;
	private List<Player> playerList;
	private League league;
	
	public Team() {
		
	}
	
	public Team(long teamId,String teamName) {
		this.teamId = teamId;
		this.teamName = teamName;
	}

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}
	
	
}
