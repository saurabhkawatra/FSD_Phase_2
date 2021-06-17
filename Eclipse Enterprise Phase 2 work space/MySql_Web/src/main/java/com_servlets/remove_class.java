package com_servlets;

import java.io.IOException;
import java.io.PrintWriter;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com_dbms.class_base;




@WebServlet("/remove_class")
public class remove_class extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public remove_class() {
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String[] remove_class_ids=request.getParameterValues("removeclass");
		
		out.println("<h1>remove_class servlet</h1>");
		
		if(remove_class_ids==null)
		{
			out.println("<h3>No options Selected for removing</h3>");
			out.println("<h3><a href='Home.jsp'>Go to home</a></h3>");
			
		}
		else
		{
			class_base s=new class_base();
			for(String e:remove_class_ids)
			{
				for(class_base su:s.getallclasses())
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
						out.println("<h3>Class "+s.getName()+" with ID "+s.getId()+" has been removed from the database</h3>");
					}
				}
				
			}
		}
		
		
		
	}

}
