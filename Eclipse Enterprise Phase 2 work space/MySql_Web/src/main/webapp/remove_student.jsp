<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com_dbms.student" %>
    <%@ page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Student Jsp</title>
</head>
<body>
<%
out.println("<h1>remove_student.jsp</h1>");
student s1=new student();
List<student> list=s1.getallstudents();
if(list==null)
{
	out.println("<h3>Student List is Empty</h3>");
}
else
{
	
	out.println("<form action=\"remove_student\" method=\"post\">");
	out.println("<table border='5'cellpadding='20' style='text-align:center'>");
	out.println("<tr style='font-weight:bold'>");	
	out.println("<td>Select below</td><td>Student_Name</td><td>Student_ID</td><td>Student_DOB</td><td>Student_City</td>");	
	out.println("</tr>");
	for(student s:list)
	{
		out.println("<tr>");
		out.println("<td><input type=\"checkbox\" name=removestudent value='"+s.getId()+"'></td>");
		out.println("<td>"+s.getName()+"</td>"+"<td>"+s.getId()+"</td>"+"<td>"+s.getDob()+"</td>"+"<td>"+s.getCity()+"</td>");	
		out.println("</tr>");			
	}
	out.println("</table>");
	
	
}
%>
<h1><input type="submit" value="Remove Selected Students"></h1>
</form>
</body>
</html>