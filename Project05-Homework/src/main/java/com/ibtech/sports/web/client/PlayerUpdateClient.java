package com.ibtech.sports.web.client;

import java.net.URLConnection;
import org.w3c.dom.Document;

import com.ibtech.core.utils.StreamHelper;
import com.ibtech.core.utils.WebHelper;
import com.ibtech.core.utils.XmlHelper;
import com.ibtech.sports.database.entity.Player;
import com.ibtech.sports.xml.PlayerXml;

public class PlayerUpdateClient {
	public static void main(String[] args) {
		
		try {
			String address = "http://localhost:8080/Project05-Homework/player/update";
			Player player = new Player(12,"Yıldırım Gürses",3240);
			Document document = PlayerXml.format(player);
			URLConnection connection = WebHelper.connect(address);
			connection.setRequestProperty("content-type", "application/xml;charset=UTF-8");
			XmlHelper.dump(document, connection.getOutputStream());
			
			String result = StreamHelper.read(connection.getInputStream());
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
