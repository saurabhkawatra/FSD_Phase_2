<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Date"%>
    <%@page import="java.util.Enumeration"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ include file="header.jsp"%>

<h2>Dasboard Page</h2>

    <%
        //session = request.getSession(false);
    if (session.getAttribute("uname") != null) {
       
    	out.println("Welcome " + session.getAttribute("uname") + "!!");
    	out.println("Session Id : " + session.getId());
        out.println("<br /><br />");
        out.println("session.getAttributeNames().toString()= "+session.getAttributeNames().toString());
        out.println("<br /><br />");
        out.println("Session Creation Date : " + new Date(session.getCreationTime()));
        out.println("<br /><br />");
        out.println("request.getAttributeNames().toString() = "+ request.getAttributeNames().toString());
        out.println("<br /><br />");
        
        
        Enumeration<String> reqAttributeNames=request.getAttributeNames();
        while(reqAttributeNames.hasMoreElements())
        {
        	String name=reqAttributeNames.nextElement();
        	out.println("<p>reqAttributeNames = "+name+" corresponding value= "+request.getAttribute(name)+"</p>");
        }
        out.println("<br /><br />");
        Enumeration<String> sesAttributeNames=session.getAttributeNames();
        while(sesAttributeNames.hasMoreElements())
        {
        	String name=sesAttributeNames.nextElement();
        	out.println("<p>sesAttributeNames = "+name+" corresponding value= "+session.getAttribute(name)+"</p>");
        }
        out.println("<br /><br />");
        Enumeration<String> reqParameterNames=request.getParameterNames();
        while(reqParameterNames.hasMoreElements())
        {
        	String name=reqParameterNames.nextElement();
        	out.println("<p>reqParameterNames = "+name+" corresponding value= "+request.getParameter(name)+"</p>");
        }
        out.println("<br /><br />");
        
        out.println("request.getLocalAddr()= "+request.getLocalAddr());
		out.println("request.getRemoteAddr()= "+request.getRemoteAddr());
        
    } else {
        response.sendRedirect("login.jsp");
    }
    %>
<%
//session = request.getSession(false);
//out.println(session.getId());
//out.println(session.getAttributeNames().toString());
//out.println(new Date(session.getCreationTime()));
//out.println("Welcome"+ session.getAttribute("uname")+"!!");
%>

</body>
</html>