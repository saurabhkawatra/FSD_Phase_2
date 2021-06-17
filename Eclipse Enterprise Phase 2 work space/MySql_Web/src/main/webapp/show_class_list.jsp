<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com_dbms.class_base" %>
    <%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Class List Jsp</title>
</head>
<body>

<%
out.println("<h1>show_class_list.jsp</h1>");
class_base s1=new class_base();
List<class_base> list=s1.getallclasses();
if(list==null)
{
	out.println("<h3>Class List is Empty</h3>");
}
else
{
	out.println("<table border='5'cellpadding='20' style='text-align:center'>");
	out.println("<tr style='font-weight:bold'>");	
	out.println("<td>Class_Name</td><td>Class_ID</td>");	
	out.println("</tr>");
	for(class_base s:list)
	{
		out.println("<tr>");	
		out.println("<td>"+s.getName()+"</td>"+"<td>"+s.getId()+"</td>");	
		out.println("</tr>");			
	}
	out.println("</table>");
}
%>

</body>
</html>