<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com_dbms.student" %>
    <%@ page import="com_dbms.class_base" %>
    <%@ page import="java.util.List" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign Student to Class Jsp</title>
</head>
<body>

<h1>assign_student_to_class.jsp</h1>

<%
student s1=new student();
List<student> studentlist=s1.getallstudents();
class_base c1=new class_base();
List<class_base> classlist=c1.getallclasses();
if(studentlist==null||studentlist.isEmpty())
{
	out.println("<h3>There are no students in the database, Add Students before assigning</h3>");
	out.println("<h3><a href='add_student.jsp'>Add Students</a></h3>");
	
	if(classlist==null||classlist.isEmpty())
	{
		out.println("<h3>Also, there are no classes too in the database, Add Classes before assigning</h3>");
		out.println("<h3><a href='add_class.jsp'>Add Classes</a></h3>");
	}
}
else if(classlist==null||classlist.isEmpty())
{
	out.println("<h3>There are no Classes in the database, Add Classes before assigning</h3>");
	out.println("<h3><a href='add_class.jsp'>Add Classes</a></h3>");
}
else
{
	out.println("<form action='assign_student_to_class' method='post'>");
	
	out.println("<h3>Select the Class in which selected students will be assigned to ");
	out.println(" <select name='classid_for_student'>");
	out.println("<option value=''>Select Class</option>");
	for(class_base c:classlist)
	{
		out.println("<option value='"+c.getId()+"'>"+c.getName()+"</option>");
	}
	out.println("</select></h3>");
	out.println("<input type='submit' value='Assign Selected Students'>");
	
	out.println("<h3>Select Students that are to be assigned to the Class</h3>");

	out.println("<table border='5'cellpadding='20' style='text-align:center'>");
	out.println("<tr>");
	out.println("<td>Select here</td><td>Student_Name</td><td>Student_Id</td><td>Student_DOB</td><td>Student_City</td>");
	out.println("</tr>");
	for(student s:studentlist)
	{
		out.println("<tr>");
		out.println("<td><input type='checkbox' name='assignStudentToClass' value='"+s.getId()+"'></td>");
		out.println("<td>"+s.getName()+"</td>"+"<td>"+s.getId()+"</td>"+"<td>"+s.getDob()+"</td>"+"<td>"+s.getCity()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>");
		
	out.println("</form>");
	
}
%>

</body>
</html>