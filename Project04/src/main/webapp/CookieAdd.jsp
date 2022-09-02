<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	Cookie cookie = new Cookie("company","godoro");
	response.addCookie(cookie);
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
Çerez eklendi : <%=cookie.getValue()%>
</body>
</html>