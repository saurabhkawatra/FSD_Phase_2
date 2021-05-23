package com.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servlet1() {
       
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<h1>This is the end of the Get Method servlet1</h1>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		RequestDispatcher rd1 = request.getRequestDispatcher("Success.jsp");
		RequestDispatcher rd2 = request.getRequestDispatcher("home.jsp");
		
		response.getWriter().println("<h1>This is the Welcome println message from servlet1</h1>");
		
		response.getWriter().append("<h1>The below content if from Success.jsp</h1>");
		rd1.include(request, response);
		
		response.getWriter().append("<h1>This is from the Post Method servlet1 User Name entered:-"
				+request.getParameter("Login_Name")+"Password Entered :-"+request.getParameter("Login_Password")+"</h1>");
		
		response.getWriter().append("<h1>The below content is from home.jsp</h1>");
		rd2.include(request, response);
		
		response.getWriter().append("<h1>This is the end of the Post Method servlet1</h1>");
	}

}
