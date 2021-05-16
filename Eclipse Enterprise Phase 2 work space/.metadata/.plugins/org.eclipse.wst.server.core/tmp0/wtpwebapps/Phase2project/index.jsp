<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Home JSP page
<%! int number=10; %>
<%!int addition(int num1,int num2)
{
	return num1 +num2;
}

%>
<h4><%="value of number :"+number %></h4>
<h4><%="Result:"+addition(100,200) %></h4>
<h4><%! %>></h4>
</body>
</html>