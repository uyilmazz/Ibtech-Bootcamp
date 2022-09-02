<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.ibtech.rectangle.Rectangle,com.ibtech.auth.User,com.ibtech.auth.UserManager"%>

<%
String username = "";
String password = "";
String message = (String) session.getAttribute("message") != null ? (String) session.getAttribute("message") : "";
try {

	if ((request.getParameter("login")) != null) {
		username = request.getParameter("username");
		password = request.getParameter("password");
		UserManager userManager = new UserManager();
		User user = userManager.findByUserName(username);
		if ((user != null && (user.getUsername().equals(username) && user.getPassword().equals(password)))) {
	session.setAttribute("username", username);
	response.sendRedirect("HomeWithDB.jsp");
		} else {
	message = "Yanlış!";
		}
	}
} catch (Exception e) {
	message = "Hata";
	e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=message%><br><br>

	<form action="" method="POST">
		Username : <input type="text" name="username" value="<%=username%>" /><br><br> 
		Password : <input type="text" name="password" value="<%=password%>" /><br><br> 
		<input type="submit" value="Login" name="login" /><br><br>
		Hesabınız yok mu?<a href="Register.jsp">Kayıt olun</a>
	</form>
</body>
</html>