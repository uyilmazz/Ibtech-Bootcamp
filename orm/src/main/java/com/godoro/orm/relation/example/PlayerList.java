package com.godoro.orm.relation.example;

import com.godoro.orm.relation.entity.Player;
import com.godoro.orm.relation.repository.PlayerRepository;

public class PlayerList {

	public static void main(String[] args) {
		PlayerRepository repository = new PlayerRepository();
		for(Player player : repository.list()) {
			System.out.println(player.getPlayerName());
		}
	}
}
