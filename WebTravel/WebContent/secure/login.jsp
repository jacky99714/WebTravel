<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="formLogin" action="/WebTravel/LoginServlet" method="get">
		<input id="name" name="useid" type="text" value="${param.useid}"><br>
		<input id="password" name="password" type="password" value="${param.password}"><br>
		<input type="submit" id="btn1">
	</form>
</body>
</html>