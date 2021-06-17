package com.saurabh;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public LogoutServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        
        if(session != null) {
            session.invalidate();
            // out.println("You are successfully logged out.");
            response.sendRedirect("login.jsp");
        }
	}

}
