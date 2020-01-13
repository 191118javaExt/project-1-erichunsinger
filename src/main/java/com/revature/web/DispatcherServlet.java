package com.revature.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.revature.service.ReimbSvcImpl;
import com.revature.service.UserSvcImpl;

public class DispatcherServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3651884531167712712L;
	private static final Logger logger = Logger.getLogger(DispatcherServlet.class);
	private UserSvcImpl uServices = new UserSvcImpl();
	private ReimbSvcImpl reimServices = new ReimbSvcImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Front controller GET handling requests");
		final String URI = request.getRequestURI().replace("/ProjectOne/", "");
	
		switch (URI) {
			case "logout":
	
				break;
			case "getTable":				
				reimServices.getReimbById(request, response);
				break;
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.error("Front controller POST handling requests");

		final String URI = request.getRequestURI().replace("/ProjectOne/", "");

		switch (URI) {
			case "login":
				uServices.verifyUser(request, response);
				break;
			case "createTicket":
				reimServices.insertTicket(request, response);
				break;
		}

	}
}
