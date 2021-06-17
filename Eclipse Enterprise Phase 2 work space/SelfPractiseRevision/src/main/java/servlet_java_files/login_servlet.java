package servlet_java_files;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public login_servlet() {
      
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("login_servlet is executed");
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		
	}

}
