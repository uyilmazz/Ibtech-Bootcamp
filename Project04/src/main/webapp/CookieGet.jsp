<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%!
public static String getCookieValue(HttpServletRequest request,String name,String defaultValue){
	String value = defaultValue;
	if(request.getCookies() != null){
		for(Cookie cookie : request.getCookies()){
			if(cookie.getName().equals("company")){
				value = cookie.getValue();
			}
		}
	}
	return value;
}
%>    
    
<%
	// String company = getCookieValue(request,"company","")
	String company = "";
	if(request.getCookies() != null){
		for(Cookie cookie : request.getCookies()){
			if(cookie.getName().equals("company")){
				company = cookie.getValue();
			}
		}
	}
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
Çerez alındı : <%=company%>
</body>
</html>