package com.ibtech.transaction.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibtech.transaction.entity.Transaction;
import com.ibtech.transaction.utils.StreamUtilities;
import com.ibtech.transaction.utils.TransactionConverter;

@WebServlet("/get")
public class GetServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		OutputStream out = response.getOutputStream();
		
		Transaction transaction = new Transaction(501,"Elektrik Ödemesi",5460);
		String line = TransactionConverter.format(transaction);
		StreamUtilities.write(out, line);
		System.out.println(line);
	}
}
