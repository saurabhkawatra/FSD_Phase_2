package com_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com_dbms.student;
import com_dbms.teacher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/remove_teacher")
public class remove_teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public remove_teacher() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String[] remove_teach_ids=request.getParameterValues("removeteacher");
		
		out.println("<h1>remove_teacher servlet</h1>");
		
		if(remove_teach_ids==null)
		{
			out.println("<h3>No options Selected for removing</h3>");
			out.println("<h3><a href='Home.jsp'>Go to home</a></h3>");
			
		}
		else
		{
			teacher s=new teacher();
			for(String e:remove_teach_ids)
			{
				for(teacher su:s.getallteachers())
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
					if(s.remove_teacher(e)==1)
					{
						out.println("<h3>Teacher "+s.getName()+" with ID "+s.getId()+" has been removed from the database</h3>");
					}
				}
				
			}
		}
		
		
		
	}

}
