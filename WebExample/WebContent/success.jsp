<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success Page</title>
</head>
<body>
success<br>
<label id="wcp12">Welcome:</label> 
<h1><label id="usrnm"><%=request.getAttribute("user") %></label></h1>
<%=request.getAttribute("customMessage") %>
</body>
</html>