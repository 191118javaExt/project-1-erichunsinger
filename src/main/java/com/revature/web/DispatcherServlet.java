package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class DispatcherServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(DispatcherServlet.class);

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("**************** log my message ***************");

		//HttpSession session = request.getSession(false);

		/*
		 * if (session == null) {
		 * request.getRequestDispatcher("index.html").include(request, response); }
		 */

		StringBuffer url = request.getRequestURL();
		String[] splitTemp = url.toString().split("/");
		String endPoint = splitTemp[splitTemp.length - 1];
		if (endPoint.equals("login"))
			request.getRequestDispatcher("MainServlet").include(request, response);
		else if (url.equals("newrequest"))
			request.getRequestDispatcher("MainServlet").include(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		logger.error("**************** log my message ***************");
	}
}
