<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Teacher Jsp</title>
</head>
<body>

<%
out.println("<h1>add_teacher.jsp</h1>");
%>
<form action="add_teacher" method="post">
<h3>Enter Teacher Name <input type="text" name="teacher_name"></h3>
<h3>Enter Teacher DOB (DD/MM/YYYY) <input type="date" name="teacher_dob"></h3>
<h3>Enter Teacher's City <input type="text" name="teacher_city"></h3>
<input type="submit" value="Submit">
</form>

</body>
</html>