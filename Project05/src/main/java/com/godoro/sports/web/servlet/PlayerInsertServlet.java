package com.godoro.sports.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.godoro.core.utils.StreamHelper;
import com.godoro.core.utils.XmlHelper;
import com.godoro.sports.database.entity.Player;
import com.godoro.sports.database.manager.PlayerManager;
import com.godoro.sports.xml.PlayerXml;


@WebServlet("/player/insert")
public class PlayerInsertServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Document document = XmlHelper.parse(request.getInputStream());
			Player player = PlayerXml.parse(document);
			PlayerManager playerManager = new PlayerManager();
			boolean inserted = playerManager.insert(player);
			String result = inserted ? "Eklendi" : "Eklenmedi";
			StreamHelper.write(response.getOutputStream(),result);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
