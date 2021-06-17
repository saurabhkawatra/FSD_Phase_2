package com_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com_dbms.subject;
import com_dbms.teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/add_subject")
public class add_subject extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public add_subject() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		subject s1=new subject();
		
		out.println("<h3>add_subject servlet</h3>");
		
		try {
			s1.setName(request.getParameter("subject_name"));
			s1.setDomain(request.getParameter("subject_domain"));
			s1.generate_subject_id();
			s1.storeindatabase();
			
			out.println("<p>Subject Added</p>");
			out.println("<p>Subject Name = "+s1.getName()+"</p>");
			out.println("<p>Subject Id = "+s1.getId()+"</p>");
			out.println("<p>Subject Domain = "+s1.getDomain()+"</p>");
		}
		catch(Exception ex)
		{
			out.println("<h1>Some Error Occured while adding a New Subject! Please try Again</h1>");
			out.println("<h1><a href=\"add_subject.jsp\"><h3>Add Teacher</h3></a></h1>");
			System.out.println("com_servlets_add_subject.java3 "+ex);
			System.out.println("com_servlets_add_subject.java3 "+ex.getMessage());
		}
	}

}
