<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student Jsp</title>
</head>
<body>
<%
out.println("<h1>add_student.jsp</h1>");
%>
<form action="add_student" method="post">
<h3>Enter Student Name <input type="text" name="student_name"></h3>
<h3>Enter Student DOB (DD/MM/YYYY) <input type="date" name="student_dob"></h3>
<h3>Enter Student's City <input type="text" name="student_city"></h3>
<input type="submit" value="Submit">
</form>

</body>
</html>