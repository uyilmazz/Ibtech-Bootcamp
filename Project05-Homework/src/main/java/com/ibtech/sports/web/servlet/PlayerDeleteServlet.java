package com.ibtech.sports.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibtech.core.utils.StreamHelper;
import com.ibtech.sports.database.manager.PlayerManager;

@WebServlet("/player/delete")
public class PlayerDeleteServlet extends HttpServlet{

	
	// Postman vb. test araçları üzerinden delete methodu ile istek atıldığında çalışmaktadır.
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long playerId = Long.parseLong(request.getParameter("playerId"));
			PlayerManager playerManager = new PlayerManager();
			boolean deleted = playerManager.delete(playerId);
			String message = deleted ? "Silindi" : "Silinmedi";
			StreamHelper.write(response.getOutputStream(),message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			long playerId = Long.parseLong(request.getParameter("playerId"));
			PlayerManager playerManager = new PlayerManager();
			boolean deleted = playerManager.delete(playerId);
			String message = deleted ? "Silindi" : "Silinmedi";
			StreamHelper.write(response.getOutputStream(),message);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
