package com_servlets;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com_dbms.class_base;


@WebServlet("/add_class")
public class add_class extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public add_class() {
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		class_base s1=new class_base();
		
		out.println("<h3>add_class servlet</h3>");
		
		try {
			s1.setName(request.getParameter("class_name"));
			s1.generate_class_id();
			s1.storeindatabase();
			
			out.println("<p>Class Added</p>");
			out.println("<p>Class Name = "+s1.getName()+"</p>");
			out.println("<p>Class Id = "+s1.getId()+"</p>");
		}
		catch(Exception ex)
		{
			out.println("<h1>Some Error Occured while adding a New Class! Please try Again</h1>");
			out.println("<h1><a href=\"add_class.jsp\"><h3>Add Class</h3></a></h1>");
			System.out.println("com_servlets_add_class.java3 "+ex);
			System.out.println("com_servlets_add_class.java3 "+ex.getMessage());
		}
		
		
	}

}
