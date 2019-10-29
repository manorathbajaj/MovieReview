<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup Form</title>
</head>
<body>
 	<form:form commandName="user">
	First Name : <form:input path="fName"/>  <form:errors path="fName"/><br/>
	Last Name : <form:input path="lName"/> <form:errors path="lName"/> <br/>
	User Name : <form:input path="uName"/> <form:errors path="uName"/> <br/>
	Password : <form:password path="password"/> <form:errors path="password"/> <br/>
	Email : <form:password path="email"/> <form:errors path="email"/> <br/>
	Account Type : <form:select path="uType">
						<form:option value="1">Viewer</form:option>
						<form:option value="2">Critic</form:option>
					</form:select>
	
	
	<input type="submit"/>
</form:form>
</body>
</html>
