<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ibtech.rectangle.Rectangle" %>
<%

	Rectangle rectangle = new Rectangle(0,0);
	int area = 0;
	int perimeter = 0;
	if((request.getParameter("calculateArea"))!= null){
		rectangle.setWeight(Integer.parseInt(request.getParameter("weight")));
		rectangle.setHeight(Integer.parseInt(request.getParameter("height")));
		perimeter = Integer.parseInt(request.getParameter("perimeter"));
		area = rectangle.getArea();
	}
	
	if((request.getParameter("calculatePerimeter"))!= null){
		rectangle.setWeight(Integer.parseInt(request.getParameter("weight")));
		rectangle.setHeight(Integer.parseInt(request.getParameter("height")));
		area = Integer.parseInt(request.getParameter("area"));
		perimeter = rectangle.getPerimeter();
	}
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Area : <%=area %><br><br>
	Perimeter : <%=perimeter%><br><br>
<form action="Rectangle.jsp" method="POST">
	Weight : <input type="text" name="weight" value="<%=rectangle.getWeight() %>" /><br/><br>
	Height : <input type="text" name="height" value="<%=rectangle.getHeight() %>" /><br/><br>
			<input type="hidden" name="area" value="<%=area %>"/>
			<input type="hidden" name="perimeter" value="<%=perimeter %>"/>
			<input type="submit" value="Area" name="calculateArea">
			<input type="submit" value="Perimeter" name ="calculatePerimeter">
</form>
</body>
</html>