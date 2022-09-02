package com.ibtech.sports.xml;

import org.w3c.dom.*;

import com.ibtech.core.utils.XmlHelper;
import com.ibtech.sports.database.entity.Player;

public class PlayerXml {

	public static Document format(Player player) throws Exception {
		Document document = XmlHelper.create("player");
		Element root = document.getDocumentElement();
		XmlHelper.addSingleElement(document, root, "playerId", player.getPlayerId(), null, null);
		XmlHelper.addSingleElement(document, root, "playerName", player.getPlayerName(), null, null);
		XmlHelper.addSingleElement(document, root, "averageScore", player.getAverageScore(), null, null);
		return document;
	}
	
	public static Player parse(Document document) {
		Element root = document.getDocumentElement();
		long playerId = (long) XmlHelper.getSingleElementText(root, "playerId", 0);
		String playerName = XmlHelper.getSingleElementText(root, "playerName", "");
		double averageScore = Double.parseDouble(XmlHelper.getSingleElementText(root, "averageScore", "0"));
		
		Player player = new Player(playerId,playerName,averageScore);
		return player;
	}
}
