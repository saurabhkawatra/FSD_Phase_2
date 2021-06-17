package com.saurabh;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DepartmentServlet() {
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("header.jsp");
		rd.include(request, response);
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trainingdb","root","dattago1");
			PreparedStatement statement = con.prepareStatement("Select * from departments");
			ResultSet rs = statement.executeQuery();
			out.println("<table border='5' cell-spacing='3'>");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				out.println("<h1>"+"<tr>"+"<td>"+rs.getInt(1)+"</td>"+"<td>"+rs.getString(2)+"<td>"+rs.getString(3)+"</tr>"+"</h1>");
			}
			out.println("</table>");
			con.close();
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		
		
	}

}
