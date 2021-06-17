<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>Home Page</h1>

<%for(int i=0;i<20;i++){ %>
<%=i%><br/>wow wow
<form action="login" method="post">
<h3>User Name <input type="text" name="username" placeholder="Enter user name here.."> </h3>
<h3>Password <input type="text" name="password" placeholder="Enter password here.."> </h3>
<input type="submit" value="login by input"><button type="submit">login by button</button>
</form>
<%} %>

</body>
</html>