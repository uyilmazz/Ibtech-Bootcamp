package com.ibtech.sports.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ibtech.core.utils.StreamHelper;
import com.ibtech.core.utils.XmlHelper;
import com.ibtech.sports.database.entity.Player;
import com.ibtech.sports.database.manager.PlayerManager;
import com.ibtech.sports.xml.PlayerXml;

@WebServlet("/player/update")
public class PlayerUpdateServlet extends HttpServlet{

	// Postman vb. test araçları üzerinden delete methodu ile istek atıldığında çalışmaktadır.
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Document document = XmlHelper.parse(request.getInputStream());
			Player player = PlayerXml.parse(document);
			PlayerManager playerManager = new PlayerManager();
			boolean updated = playerManager.update(player);
			String result = updated ? "Güncellendi" : "Güncellenmedi";
			StreamHelper.write(response.getOutputStream(),result);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Document document = XmlHelper.parse(request.getInputStream());
			Player player = PlayerXml.parse(document);
			PlayerManager playerManager = new PlayerManager();
			boolean updated = playerManager.update(player);
			String result = updated ? "Güncellendi" : "Güncellenmedi";
			StreamHelper.write(response.getOutputStream(),result);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
