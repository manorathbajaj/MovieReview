<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/movie/login.htm" method="post">
	User Name : <input type="text" name="uName" required="required"/>  <br/>
	Password : <input type="password" name="password" required="required"/>  <br/>
	
	<input type="submit" name="login"/>
</form>
</body>
</html>