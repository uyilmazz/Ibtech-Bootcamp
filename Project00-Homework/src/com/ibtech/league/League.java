package com.ibtech.league;

import java.util.List;

public class League {
	private long leagueId;
	private String leagueName;
	private List<Team> teamList;
	
	public League() {
		super();
	}

	public League(long leagueId, String leagueName) {
		super();
		this.leagueId = leagueId;
		this.leagueName = leagueName;
	}

	public long getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(long leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public List<Team> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<Team> teamList) {
		this.teamList = teamList;
	}
	
}
