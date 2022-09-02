<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%
	String username = (String) session.getAttribute("username");
%>
   

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	Oturumdan alındı : <%=username %>
</body>
</html>