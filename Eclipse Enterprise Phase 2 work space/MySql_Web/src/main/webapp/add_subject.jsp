<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject Jsp</title>
</head>
<body>

<%
out.println("<h1>add_subject.jsp</h1>");
%>
<form action="add_subject" method="post">
<h3>Enter Subject Name <input type="text" name="subject_name"></h3>
<h3>
Choose Subject's Domain 
<select name="subject_domain">
<option value="Science">Science</option>
<option value="History">History</option>
<option value="Civics">Civics</option>
<option value="Geography">Geography</option>
<option value="Mathematics">Mathematics</option>
<option value="Electronic Technology">Electronic Technology</option>
<option value="Computer Technology">Computer Technology</option>
<option value="Elementary Science">Elementary Science</option>
<option value="Elementary Basics">Elementary Basics</option>
</select>
</h3>

<input type="submit" value="Submit">
</form>

</body>
</html>