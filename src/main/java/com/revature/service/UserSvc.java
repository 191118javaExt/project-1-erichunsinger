package com.revature.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserSvc {	
	void verifyUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}