package com_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com_dbms.student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/remove_student")
public class remove_student extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public remove_student() {
       
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String[] remove_stu_ids=request.getParameterValues("removestudent");
		
		out.println("<h1>remove_student servlet</h1>");
		
		if(remove_stu_ids==null)
		{
			out.println("<h3>No options Selected for removing</h3>");
			out.println("<h3><a href='Home.jsp'>Go to home</a></h3>");
			
		}
		else
		{
			student s=new student();
			for(String e:remove_stu_ids)
			{
				for(student su:s.getallstudents())
				{
					if(su.getId().equals(e))
					{
						s=su;
					}
				}
				if(s.getName()==null)
				{
					out.println("<h3>Selected Id has already been Deleted from the database</h3>");
				}
				else
				{
					if(s.remove_student(e)==1)
					{
						out.println("<h3>Student "+s.getName()+" with ID "+s.getId()+" has been removed from the database</h3>");
					}
				}
				
			}
		}
		
		
	}

}
