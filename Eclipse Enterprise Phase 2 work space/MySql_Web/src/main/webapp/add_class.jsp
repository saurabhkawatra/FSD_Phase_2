<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Class Jsp</title>
</head>
<body>

<%
out.println("<h1>add_class.jsp</h1>");
%>
<form action="add_class" method="post">
<h3>Enter Class Name <input type="text" name="class_name"></h3>

<input type="submit" value="Submit">
</form>

</body>
</html>