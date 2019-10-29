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
	<body>
 	<form:form commandName="movie" >
	Name : <form:input path="name"/>  <form:errors path="name"/><br/>
	Actor : <form:input path="actor"/> <form:errors path="actor"/> <br/>
	Actress : <form:input path="actress"/> <form:errors path="actress"/> <br/>
	Genre : <form:password path="genre"/> <form:errors path="genre"/> <br/>
	Year : <form:input path="year"/> <form:errors path="year"/> <br/>
	<input type="submit"/>
</form:form>

</body>
</html>