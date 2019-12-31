package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.UserModel;
import com.revature.repositories.UsersDAOImpl;

public class MainServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2175311913683463107L;

	UsersDAOImpl dao = new UsersDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String param = req.getParameter("test");
		res.setContentType("text/plain");
		System.out.println("received GET Request");
		PrintWriter out = res.getWriter();
		out.println("Response back to JavaScript");
	}
	
	@Override
	protected void doPost (HttpServletRequest req, HttpServletResponse res) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = req.getReader();
		ObjectMapper om = new ObjectMapper();
		PrintWriter out = res.getWriter();
		
		System.out.println("Received POST request");
		String line = "";
		while(( line = br.readLine()) != null) {
			
			sb.append(line);
		}
		String data = sb.toString();
		System.out.println(sb.toString());
		UserModel model = om.readValue(data, UserModel.class);
		model = dao.verifyUser(model);
		
		System.out.println(model.toString());
		String json = om.writeValueAsString(model);
		out.append(json);
	}
}
