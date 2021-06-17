<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com_dbms.class_base" %>
    <%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Class Jsp</title>
</head>
<body>

<%
out.println("<h1>remove_class.jsp</h1>");
class_base s1=new class_base();
List<class_base> list=s1.getallclasses();
if(list==null)
{
	out.println("<h3>Class List is Empty</h3>");
}
else
{
	
	out.println("<form action=\"remove_class\" method=\"post\">");
	out.println("<table border='5'cellpadding='20' style='text-align:center'>");
	out.println("<tr style='font-weight:bold'>");	
	out.println("<td>Select below</td><td>Class_Name</td><td>Class_ID</td>");	
	out.println("</tr>");
	for(class_base s:list)
	{
		out.println("<tr>");
		out.println("<td><input type=\"checkbox\" name=removeclass value='"+s.getId()+"'></td>");
		out.println("<td>"+s.getName()+"</td>"+"<td>"+s.getId()+"</td>");	
		out.println("</tr>");			
	}
	out.println("</table>");
}
%>
<h1><input type="submit" value="Remove Selected Classes"></h1>
</form>

</body>
</html>