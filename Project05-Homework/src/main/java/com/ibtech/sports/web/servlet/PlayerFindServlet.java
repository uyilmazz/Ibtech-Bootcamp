package com.ibtech.sports.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.Document;

import com.ibtech.core.utils.XmlHelper;
import com.ibtech.sports.database.entity.Player;
import com.ibtech.sports.database.manager.PlayerManager;
import com.ibtech.sports.xml.PlayerXml;

// http://localhost:8080/player/find?id=2;
@WebServlet("/player/find")
public class PlayerFindServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		try {
			long playerId = Long.parseLong(request.getParameter("playerId"));
			PlayerManager playerManager = new PlayerManager();
			Player player = playerManager.find(playerId);
			Document document = PlayerXml.format(player);
			response.setContentType("application/xml;charset=UTF-8");
			XmlHelper.dump(document, response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
