package com.saurabh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public LoginServlet() {
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	response.sendRedirect("login.jsp");
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("request.getLocalAddr()= "+request.getLocalAddr());
		System.out.println("request.getRemoteAddr()= "+request.getRemoteAddr());
		
		response.setContentType("text/html");
		String input_username=request.getParameter("username");
		String input_password=request.getParameter("password");
		String username="";
		String password="";
		
		PrintWriter out=response.getWriter();
		out.println("Login here..");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/skdatabase","root","dattago1");
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select password from users where username='"+input_username+"'");
			rs.next();
			password=rs.getString(1);
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println(ex);
		}
		
		if(password.equalsIgnoreCase(input_password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("uname",username);
			RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
			rd.forward(request, response);
			out.println("Login Successful..");
		}
		else
		{
			out.println("Login failed..");
			request.getRequestDispatcher("login.jsp").include(request, response);
			out.println("<h3 style=\"color:red\">Invalid Credetials. Please try again. </h3>");
		}
		
		
	}

}
