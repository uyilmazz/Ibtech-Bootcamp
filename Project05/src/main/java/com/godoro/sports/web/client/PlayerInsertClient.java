package com.godoro.sports.web.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLConnection;

import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;

import com.godoro.core.utils.StreamHelper;
import com.godoro.core.utils.WebHelper;
import com.godoro.core.utils.XmlHelper;
import com.godoro.sports.database.entity.Player;
import com.godoro.sports.xml.PlayerXml;

public class PlayerInsertClient {
	public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException, IOException, TransformerException {
		String address = "http://localhost:8080/player/insert";
		Player player = new Player(0,"Mahsuni Şerif",2.5);
		Document document = PlayerXml.format(player);
		URLConnection connection = WebHelper.connect(address);
		connection.setRequestProperty("content-type", "application/xml;charset=UTF-8");
		XmlHelper.dump(document, connection.getOutputStream());
		String result = StreamHelper.read(connection.getInputStream());
		System.out.println(result);
	}
}
