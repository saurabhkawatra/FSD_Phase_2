package com_servlets;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;

import com_dbms.student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com_dbms.*;


@WebServlet("/add_student")
public class add_student extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public add_student() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		student s1=new student();
		
		out.println("<h3>add_student servlet</h3>");
		
		try {
			s1.setName(request.getParameter("student_name"));
			s1.setDob(request.getParameter("student_dob"));
			s1.setCity(request.getParameter("student_city"));
			s1.generate_student_id();
			s1.storeindatabase();
			
			out.println("<p>Student Added</p>");
			out.println("<p>Student Name ="+s1.getName()+"</p>");
			out.println("<p>Student Id ="+s1.getId()+"</p>");
			out.println("<p>Student DOB ="+s1.getDob()+"</p>");
			out.println("<p>Student City ="+s1.getCity()+"</p>");
		}
		catch(Exception ex)
		{
			
			out.println("<h1>Some Error Occured while adding a New Student! Please try Again</h1>");
			out.println("<h1><a href=\"add_student.jsp\"><h3>Add Student</h3></a></h1>");
			System.out.println("com_servlets_add_student.java3 "+ex);
			System.out.println("com_servlets_add_student.java3 "+ex.getMessage());
		}
	}

}
