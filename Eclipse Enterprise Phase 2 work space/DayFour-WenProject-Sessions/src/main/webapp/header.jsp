<%
if(session.getAttribute("uname") != null)
{
	out.println("<a href=\"LogoutServlet\">Logout</a>\r\n"
    		+ "<a href=\"dashboard.jsp\">Dashboard</a>\r\n"
    		+ "<a href=\"DepartmentServlet\">Departments</a>");
}
else
{
	out.println("<a href=\"LoginServlet\">Login</a>\r\n");
}
%>

