<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String username = "godoro";
	session.setAttribute("username", username);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	Oturuma koyuldu : <%=username %>
</body>
</html>