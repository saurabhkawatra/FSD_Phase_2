<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com_dbms.subject" %>
    <%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Subject Jsp</title>
</head>
<body>
<%
out.println("<h1>remove_subject.jsp</h1>");
subject s1=new subject();
List<subject> list=s1.getallsubjects();
if(list==null)
{
	out.println("<h3>Subject List is Empty</h3>");
}
else
{
	
	out.println("<form action=\"remove_subject\" method=\"post\">");
	out.println("<table border='5'cellpadding='20' style='text-align:center'>");
	out.println("<tr style='font-weight:bold'>");	
	out.println("<td>Select below</td><td>Subject_Name</td><td>Subject_ID</td><td>Subject_Domain</td>");	
	out.println("</tr>");
	for(subject s:list)
	{
		out.println("<tr>");
		out.println("<td><input type=\"checkbox\" name=removesubject value='"+s.getId()+"'></td>");
		out.println("<td>"+s.getName()+"</td>"+"<td>"+s.getId()+"</td>"+"<td>"+s.getDomain()+"</td>");	
		out.println("</tr>");			
	}
	out.println("</table>");
	
	
}
%>
<h1><input type="submit" value="Remove Selected Subjects"></h1>
</form>
</body>
</html>