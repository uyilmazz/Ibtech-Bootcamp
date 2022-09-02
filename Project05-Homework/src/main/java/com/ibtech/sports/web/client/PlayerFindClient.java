package com.ibtech.sports.web.client;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ibtech.core.utils.WebHelper;
import com.ibtech.core.utils.XmlHelper;
import com.ibtech.sports.database.entity.Player;
import com.ibtech.sports.xml.PlayerXml;

public class PlayerFindClient {
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		long playerId = 2;
		String address = String.format("http://localhost:8080/Project05-Homework/player/find?playerId=%d",playerId);
		InputStream in = WebHelper.get(address);
		
		Document document = XmlHelper.parse(in);
		Player player = PlayerXml.parse(document);
		System.out.println(player.getPlayerId() + " " + player.getPlayerName() + " " + player.getAverageScore());
	}
}
