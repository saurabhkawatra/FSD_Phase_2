package com_servlets;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com_dbms.class_base;



@WebServlet("/assign_student_to_class")
public class assign_student_to_class extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public assign_student_to_class() {
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<h1>assign_student_to_class servlet</h1>");
		
		String[] selected_student_ids=request.getParameterValues("assignStudentToClass");
		String selected_class_id=request.getParameter("classid_for_student");
		
		if(selected_student_ids==null||selected_class_id==null||selected_class_id.equals(""))
		{
			out.println("<h3>Either Student or Class is Not Selected!</h3>");
		}
		else
		{
			class_base c1=new class_base();
			for(String s:selected_student_ids)
			{
				c1.assign_student_to_class(s,selected_class_id);
				out.println("<h3>Student with Id- "+s+" added to class with id-"+selected_class_id+"</h3>");
			}
		}
	}

}
