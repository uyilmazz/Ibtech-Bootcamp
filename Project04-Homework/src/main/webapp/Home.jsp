<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String username = "";
	if(session.getAttribute("username") != null){
		username = (String) session.getAttribute("username");
	}else{
		response.sendRedirect("Login.jsp");
	}
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hoşgeldin <%= username %><br><br>
	<a href="Logout.jsp">Çık</a>
</body>
</html>