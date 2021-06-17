<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.to.source_list,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airline Flight Details</title>
</head>
<body>


<form>
<h3>
Select the Source 
<select>
<option value="">Select here</option>
<%
List<source_list> allsources=source_list.getallsources();
for(source_list s:allsources)
{
	out.println("<option value='"+s.getSource_id()+"'>"+s.getSource()+"</option>");
}
%>
</select>
</h3>

<h3>
Select the destination

</h3>
</form>


</body>
</html>