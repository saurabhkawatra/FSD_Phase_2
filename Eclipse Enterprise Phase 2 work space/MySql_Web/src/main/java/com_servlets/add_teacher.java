package com_servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com_dbms.*;


@WebServlet("/add_teacher")
public class add_teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public add_teacher() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		teacher s1=new teacher();
		
		out.println("<h3>add_teacher servlet</h3>");
		
		try {
			s1.setName(request.getParameter("teacher_name"));
			s1.setDob(request.getParameter("teacher_dob"));
			s1.setCity(request.getParameter("teacher_city"));
			s1.generate_teacher_id();
			s1.storeindatabase();
			
			out.println("<p>Teacher Added</p>");
			out.println("<p>Teacher Name ="+s1.getName()+"</p>");
			out.println("<p>Teacher Id ="+s1.getId()+"</p>");
			out.println("<p>Teacher DOB ="+s1.getDob()+"</p>");
			out.println("<p>Teacher City ="+s1.getCity()+"</p>");
		}
		catch(Exception ex)
		{
			out.println("<h1>Some Error Occured while adding a New Teacher! Please try Again</h1>");
			out.println("<h1><a href=\"add_teacher.jsp\"><h3>Add Teacher</h3></a></h1>");
			System.out.println("com_servlets_add_teacher.java3 "+ex);
			System.out.println("com_servlets_add_teacher.java3 "+ex.getMessage());
		}
	}

}
