<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com_dbms.subject" %>
    <%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Subject List Jsp</title>
</head>
<body>
<%
out.println("<h1>show_subject_list.jsp</h1>");
subject s1=new subject();
List<subject> list=s1.getallsubjects();
if(list==null)
{
	out.println("<h3>Subject List is Empty</h3>");
}
else
{
	out.println("<table border='5'cellpadding='20' style='text-align:center'>");
	out.println("<tr style='font-weight:bold'>");	
	out.println("<td>Subject_Name</td><td>Subject_ID</td><td>Subject_Domain</td>");	
	out.println("</tr>");
	for(subject s:list)
	{
		out.println("<tr>");	
		out.println("<td>"+s.getName()+"</td>"+"<td>"+s.getId()+"</td>"+"<td>"+s.getDomain()+"</td>");	
		out.println("</tr>");			
	}
	out.println("</table>");
}
%>
</body>
</html>