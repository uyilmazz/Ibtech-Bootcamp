package com.godoro.servlet;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godoro.utils.StreamUtilities;

@WebServlet("/post")
public class PostServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String input = StreamUtilities.read(request.getInputStream());
		System.out.println("Girdi:\r\n"+input);
		StreamUtilities.write(response.getOutputStream(),"Oldu");
	}

	
}
