<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import= "com_dbms.student" %>
    <%@ page import= "java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Student List Jsp</title>
</head>
<body>
<%
out.println("<h1>show_student_list.jsp</h1>");
student s1=new student();
List<student> list=s1.getallstudents();
if(list==null)
{
	out.println("<h3>Student List is Empty</h3>");
}
else
{
	out.println("<table border='5'cellpadding='20' style='text-align:center'>");
	out.println("<tr style='font-weight:bold'>");	
	out.println("<td>Student_Name</td><td>Student_ID</td><td>Student_DOB</td><td>Student_City</td>");	
	out.println("</tr>");
	for(student s:list)
	{
		out.println("<tr>");	
		out.println("<td>"+s.getName()+"</td>"+"<td>"+s.getId()+"</td>"+"<td>"+s.getDob()+"</td>"+"<td>"+s.getCity()+"</td>");	
		out.println("</tr>");			
	}
	out.println("</table>");
}
%>
</body>
</html>