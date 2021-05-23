package java_modules;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
//import javax.servlet.*;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponse;


public class dashboard extends HttpServlet{
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
	response.setContentType("text/html");
	try {
		PrintWriter pwr=response.getWriter();
//--------------------------------
		
		
//				pwr.println("<!doctype html>");
//				pwr.println("<html lang=\"en\">");
//				pwr.println("<head>");
//				pwr.println("<meta charset=\"utf-8\">");
//				pwr.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
//				pwr.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">");
//				pwr.println("<title>Admin Dashboard</title>");
//				pwr.println("</head>");
//				pwr.println("<body style=\"background-color:black\">");
//				pwr.println("<div style=\"text-align:center\" class=\"alert alert-warning alert-dismissible fade show bg-success\" role=\"alert\">");
//				pwr.println("<strong style=\"color:black;\">Login Successful!</strong>");
//				pwr.println("<button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>");
//				pwr.println("</div>");
//				pwr.println("<div class=\"container-fluid\">");
//				pwr.println("<div class=\"row\" style=\"background-color:transparent;\">");
//				pwr.println("<div class=\"col-2\" style=\"margin:0px;padding:0px;\">");
//				pwr.println("<div class=\"card\" style=\"background-color:transparent;resize:both;margin:0px;padding:0px;\">");
//				pwr.println("<img style=\"background-color:transparent\" width=\"30px\" height=\"160px\" src=\"Admin-pic.png\" class=\"card-img-top\" alt=\"...\">");
//				pwr.println("<div class=\"card-body\">");
//				pwr.println("<p style=\"text-align:center;color:aqua;background-color:black\" class=\"card-text\">Admin Login</p>");
//				pwr.println("</div>");
//				pwr.println("</div>");
//				pwr.println("</div>");
//				pwr.println("<div class=\"col-10\" style=\"background-color:gray;text-align:center;\">");
//				pwr.println("<img style=\"background-color:transparent\" src=\"text.gif\" />");
//				pwr.println("<h1 style=\"color:aqua;text-align:center;margin-top:30px\"><----------------------Admin Login Portal----------------------></h1>");
//				pwr.println("</div>");
//				pwr.println("</div>");
//				pwr.println("</div>");
//				pwr.println("<div class=\"container-fluid\">");
//				pwr.println("<div class=\"row\">");
//				pwr.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">");
//				pwr.println("<div class=\"container-fluid\">");
//				pwr.println("<a class=\"navbar-brand\" href=\"\">Options-------></a>");
//				pwr.println("<button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
//				pwr.println("<span class=\"navbar-toggler-icon\"></span>");
//				pwr.println("</button>");
//				pwr.println("<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">");
//				pwr.println("<ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">");
//				pwr.println("<li class=\"nav-item dropdown\">");
//				pwr.println("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">");
//				pwr.println("Students");
//				pwr.println("</a>");
//				pwr.println("<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">");
//				pwr.println("<li><a class=\"dropdown-item\" href=\"#\">View All Students</a></li>");
//				pwr.println("<li><a class=\"dropdown-item\" href=\"#\">Add New Student</a></li>");
//				pwr.println("</ul>");
//				pwr.println("</li>");
//				pwr.println("<li class=\"nav-item dropdown\">");
//				pwr.println("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">");
//				pwr.println("Teachers");
//				pwr.println("</a>");
//				pwr.println("<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">");
//				pwr.println("<li><a class=\"dropdown-item\" href=\"#\">View All Teachers</a></li>");
//				pwr.println("<li><a class=\"dropdown-item\" href=\"#\">Add New Teacher</a></li>");
//				pwr.println("<li><a class=\"dropdown-item\" href=\"#\">Assign Teacher to Class and Subject</a></li>");
//				pwr.println("</ul>");
//				pwr.println("</li>");
//				pwr.println("<li class=\"nav-item dropdown\">");
//				pwr.println("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">");
//				pwr.println("Classes");
//				pwr.println("</a>");
//				pwr.println("<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">");
//				pwr.println("<li><a class=\"dropdown-item\" href=\"#\">View All Classes</a></li>");
//				pwr.println("<li><a class=\"dropdown-item\" href=\"#\">Add New Class</a></li>");
//				pwr.println("</ul>");
//				pwr.println("</li>");
//				pwr.println("<li class=\"nav-item dropdown\">");
//				pwr.println("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">");
//				pwr.println("Subjects");
//				pwr.println("</a>");
//				pwr.println("<ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">");
//				pwr.println("<li><a class=\"dropdown-item\" href=\"#\">View All Subjects</a></li>");
//				pwr.println("<li><a class=\"dropdown-item\" href=\"#\">Add New Subject</a></li>");
//				pwr.println("</ul>");
//				pwr.println("</li>");
//				pwr.println("</ul>");
//				pwr.println("</div>");
//				pwr.println("</div>");
//				pwr.println("</nav>");
//				pwr.println("</div>");
//				pwr.println("</div>");
//				pwr.println("<div class=\"container-fluid\">");
//				pwr.println("<div class=\"row\">");
//				pwr.println("<div class=\"col-2\" style=\"padding:0px;margin:0px\">");
//				pwr.println("<img src=\"Wiz.gif\" />");
//				pwr.println("</div>");
//				pwr.println("<div class=\"col-10\" style=\"padding:0px;margin:0px;border:5px solid black\">");
//				pwr.println("<!--  ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->");
//				pwr.println("<h1 style=\"color:aqua;text-align:center\">Welcome to the Home Page of the Admin Login</h1>");
//				pwr.println("<br />");
//				pwr.println("<br />");
//				pwr.println("<p style=\"color:aqua;\">Use this page to Navigate through the options</p>");
//				pwr.println("<ul>");
//				pwr.println("<li style=\"color:aqua;\">You can add a new Student from the student drop-down</li>");
//				pwr.println("<li style=\"color:aqua;\">View the list of students in the DataBase</li>");
//				pwr.println("<li style=\"color:aqua\">You can add a new Teacher</li>");
//				pwr.println("<li style=\"color:aqua\">View All the teachers in the DataBase</li>");
//				pwr.println("<li style=\"color:aqua\">Assign the teacher to different classes and subjects</li>");
//				pwr.println("<li style=\"color:aqua\">View All the classes available in the Database</li>");
//				pwr.println("<li style=\"color:aqua\">Add a new class to the List of Classes</li>");
//				pwr.println("</ul>");
//				pwr.println("<br />");
//				pwr.println("<br />");
//				pwr.println("<h1 style=\"color:aqua;text-align:center\"><-----------This Project is Made By Saurabh Kawatra------------></h1>");
//				pwr.println("<!--  ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->");
//				pwr.println("</div>");
//				pwr.println("</div>");
//				pwr.println("</div>");
//				pwr.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4\" crossorigin=\"anonymous\"></script>");
//				pwr.println("</body>");
//				pwr.println("</html>");
				
				
//-----------------------------------------------
		
		pwr.println("<!doctype html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"utf-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x\" crossorigin=\"anonymous\">\r\n"
				+ "\r\n"
				+ "    <title>Admin Dashboard</title>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "</head>\r\n"
				+ "\r\n"
				+ "<body style=\"background-color:black\">\r\n"
				+ "    <div style=\"text-align:center\" class=\"alert alert-warning alert-dismissible fade show bg-success\" role=\"alert\">\r\n"
				+ "        <strong style=\"color:black;\">Login Successful!</strong>\r\n"
				+ "        <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\r\n"
				+ "    </div>\r\n"
				+ "    <div class=\"container-fluid\">\r\n"
				+ "        <div class=\"row\" style=\"background-color:transparent;\">\r\n"
				+ "            <div class=\"col-2\" style=\"margin:0px;padding:0px;\">\r\n"
				+ "                <div class=\"card\" style=\"background-color:transparent;resize:both;margin:0px;padding:0px;\">\r\n"
				+ "                    <img style=\"background-color:transparent\" width=\"30px\" height=\"160px\" src=\"Admin-pic.png\" class=\"card-img-top\" alt=\"...\">\r\n"
				+ "                    <div class=\"card-body\">\r\n"
				+ "                        <p style=\"text-align:center;color:aqua;background-color:black\" class=\"card-text\">Admin Login</p>\r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"col-10\" style=\"background-color:gray;text-align:center;\">\r\n"
				+ "                <img style=\"background-color:transparent\" src=\"text.gif\" />\r\n"
				+ "                <h1 style=\"color:aqua;text-align:center;margin-top:30px\"><----------------------Admin Login Portal----------------------></h1>\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <div class=\"container-fluid\">\r\n"
				+ "        <div class=\"row\">\r\n"
				+ "            <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n"
				+ "                <div class=\"container-fluid\">\r\n"
				+ "                    <a class=\"navbar-brand\" href=\"\">Options-------></a>\r\n"
				+ "                    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
				+ "                        <span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "                    </button>\r\n"
				+ "                    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
				+ "                        <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
				+ "                            <li class=\"nav-item dropdown\">\r\n"
				+ "                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
				+ "                                    Students\r\n"
				+ "                                </a>\r\n"
				+ "                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n"
				+ "                                    <li><a class=\"dropdown-item\" href=\"#\">View All Students</a></li>\r\n"
				+ "                                    <li><a class=\"dropdown-item\" href=\"#\">Add New Student</a></li>\r\n"
				+ "                                </ul>\r\n"
				+ "                            </li>\r\n"
				+ "\r\n"
				+ "                            <li class=\"nav-item dropdown\">\r\n"
				+ "                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
				+ "                                    Teachers\r\n"
				+ "                                </a>\r\n"
				+ "                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n"
				+ "                                    <li><a class=\"dropdown-item\" href=\"#\">View All Teachers</a></li>\r\n"
				+ "                                    <li><a class=\"dropdown-item\" href=\"#\">Add New Teacher</a></li>\r\n"
				+ "                                    <li><a class=\"dropdown-item\" href=\"#\">Assign Teacher to Class and Subject</a></li>\r\n"
				+ "                                </ul>\r\n"
				+ "                            </li>\r\n"
				+ "\r\n"
				+ "                            <li class=\"nav-item dropdown\">\r\n"
				+ "                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
				+ "                                    Classes\r\n"
				+ "                                </a>\r\n"
				+ "                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n"
				+ "                                    <li><a class=\"dropdown-item\" href=\"#\">View All Classes</a></li>\r\n"
				+ "                                    <li><a class=\"dropdown-item\" href=\"#\">Add New Class</a></li>\r\n"
				+ "                                </ul>\r\n"
				+ "                            </li>\r\n"
				+ "\r\n"
				+ "                            <li class=\"nav-item dropdown\">\r\n"
				+ "                                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n"
				+ "                                    Subjects\r\n"
				+ "                                </a>\r\n"
				+ "                                <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n"
				+ "                                    <li><a class=\"dropdown-item\" href=\"#\">View All Subjects</a></li>\r\n"
				+ "                                    <li><a class=\"dropdown-item\" href=\"#\">Add New Subject</a></li>\r\n"
				+ "                                </ul>\r\n"
				+ "                            </li>\r\n"
				+ "                        </ul>\r\n"
				+ "                    </div>\r\n"
				+ "                </div>\r\n"
				+ "            </nav>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "    <div class=\"container-fluid\">\r\n"
				+ "        <div class=\"row\">\r\n"
				+ "            <div class=\"col-2\" style=\"padding:0px;margin:0px\">\r\n"
				+ "                <img src=\"Wiz.gif\" />\r\n"
				+ "            </div>\r\n"
				+ "            <div class=\"col-10\" style=\"padding:0px;margin:0px;border:5px solid black\">\r\n"
				+ "\r\n"
				+ "<!--  ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->\r\n"
				+ "                <h1 style=\"color:aqua;text-align:center\">Welcome to the Home Page of the Admin Login</h1>\r\n"
				+ "                <br />\r\n"
				+ "                <br />\r\n"
				+ "                <p style=\"color:aqua;\">Use this page to Navigate through the options</p>\r\n"
				+ "                <ul>\r\n"
				+ "                    <li style=\"color:aqua;\">You can add a new Student from the student drop-down</li>\r\n"
				+ "                    <li style=\"color:aqua;\">View the list of students in the DataBase</li>\r\n"
				+ "                    <li style=\"color:aqua\">You can add a new Teacher</li>\r\n"
				+ "                    <li style=\"color:aqua\">View All the teachers in the DataBase</li>\r\n"
				+ "                    <li style=\"color:aqua\">Assign the teacher to different classes and subjects</li>\r\n"
				+ "                    <li style=\"color:aqua\">View All the classes available in the Database</li>\r\n"
				+ "                    <li style=\"color:aqua\">Add a new class to the List of Classes</li>\r\n"
				+ "                </ul>\r\n"
				+ "                <br />\r\n"
				+ "                <br />\r\n"
				+ "                <h1 style=\"color:aqua;text-align:center\"><-----------This Project is Made By Saurabh Kawatra------------></h1>\r\n"
				+ "<!--  ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- -->\r\n"
				+ "\r\n"
				+ "            </div>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4\" crossorigin=\"anonymous\"></script>\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>");
				
	}catch(Exception e)
	{
		System.out.println(e.getMessage());
		
	}
	
}

public void doGet(HttpServletRequest request,HttpServletResponse response)
{
	response.setContentType("text/html");
	try
	{
		PrintWriter pwr=response.getWriter();
		
		pwr.println("<body style=\"background-color:blue\">");
		pwr.println("<h1 align=\"center\" style=\"background-color:black;color:red\">This page cannot be opened directly. Login to the Admin portal!</h1>");
		pwr.println("<p align=\"center\"><img type=\"png\" src=\"oops.png\"></img><p>");
		pwr.println("</body>");
	}
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
}
	
}
