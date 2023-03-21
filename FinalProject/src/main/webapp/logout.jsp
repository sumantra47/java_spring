<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Banking System</title>
</head>
<body>
	<% session.invalidate();%>
	
	<%	
        String redirectURL = "http://localhost:8083/FinalProject/login.jsp";
        response.sendRedirect(redirectURL);
    %>
</body>
</html>