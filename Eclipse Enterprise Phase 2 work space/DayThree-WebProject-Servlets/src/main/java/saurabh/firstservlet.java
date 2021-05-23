package saurabh;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public class firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public firstservlet() {
        super();
        
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        out.println("<p>Hello World - Service Method..</p>");
        out.println("<p>Hello World - Service Method..Welcome..."+request.getParameter("username")+"</p>");
        request.getRequestDispatcher("index.jsp").include(request, response);
        
        
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        out.println("Hello World - doGet Method..");
		
	}
	}


