<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com_dbms.teacher" %>
    <%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Teacher Jsp</title>
</head>
<body>
<%
out.println("<h1>remove_teacher.jsp</h1>");
teacher s1=new teacher();
List<teacher> list=s1.getallteachers();
if(list==null)
{
	out.println("<h3>Teacher List is Empty</h3>");
}
else
{
	
	out.println("<form action=\"remove_teacher\" method=\"post\">");
	out.println("<table border='5'cellpadding='20' style='text-align:center'>");
	out.println("<tr style='font-weight:bold'>");	
	out.println("<td>Select below</td><td>Teacher_Name</td><td>Teacher_ID</td><td>Teacher_DOB</td><td>Teacher_City</td>");	
	out.println("</tr>");
	for(teacher s:list)
	{
		out.println("<tr>");
		out.println("<td><input type=\"checkbox\" name=removeteacher value='"+s.getId()+"'></td>");
		out.println("<td>"+s.getName()+"</td>"+"<td>"+s.getId()+"</td>"+"<td>"+s.getDob()+"</td>"+"<td>"+s.getCity()+"</td>");	
		out.println("</tr>");			
	}
	out.println("</table>");
	
	
}
%>
<h1><input type="submit" value="Remove Selected Teachers"></h1>
</form>
</body>
</html>