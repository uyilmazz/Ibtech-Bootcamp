<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.*"%>
<%@ page
	import="com.ibtech.rectangle.Rectangle,com.ibtech.auth.User,com.ibtech.auth.UserManager"%>
<%
	String username = "";
	String password = "";
	String message = "";
	try{
		if(request.getParameter("register") != null){
			User user = new User();
			username = request.getParameter("username");
			password = request.getParameter("password");
			user.setUsername(username);
			user.setPassword(password);
			UserManager userManager = new UserManager();
			Map<String,Object> result = userManager.create(user);
			if((Boolean)result.get("success")){
				session.setAttribute("message", (String)result.get("message"));
				response.sendRedirect("LoginWithDB.jsp");
			}else{
				message = (String)result.get("message");
			}
		}
	}catch(Exception e){
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

	<%= message %><br><br>
<form action="" method="POST">
	Username : <input type="text" name="username" value="<%= username %>" /><br><br>
	Password : <input type="text" name="password" value="<%= password %>" /><br><br>
				<input type="submit" value="Register" name="register" />
</form>

</body>
</html>