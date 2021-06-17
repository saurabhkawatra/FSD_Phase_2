package com_servlets;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com_dbms.subject;


@WebServlet("/remove_subject")
public class remove_subject extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public remove_subject() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String[] remove_subject_ids=request.getParameterValues("removesubject");
		
		out.println("<h1>remove_subject servlet</h1>");
		
		if(remove_subject_ids==null)
		{
			out.println("<h3>No options Selected for removing</h3>");
			out.println("<h3><a href='Home.jsp'>Go to home</a></h3>");
			
		}
		else
		{
			subject s=new subject();
			for(String e:remove_subject_ids)
			{
				for(subject su:s.getallsubjects())
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
					if(s.remove_subject(e)==1)
					{
						out.println("<h3>Subject "+s.getName()+" with ID "+s.getId()+" has been removed from the database</h3>");
					}
				}
				
			}
		}
		
		
	}

}
