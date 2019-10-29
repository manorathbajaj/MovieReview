<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		 <c:forEach var="user" items="${u}">

                <b>User:</b> <c:out value="${user.getuName()}"/><br>
                <b>User Type:</b> <c:out value="${user.getuType()}"/><br>
 <!--           <b>Id:</b> <c:out value="${movie.getMovieId()}"/><br> --> 
                <a href='/movie/admin/deleteUser.htm?id=${user.getId()}' >Delete</a>
                <a href='/movie/admin/remove.htm?id=${user.getId()}' >Remove Critic</a>	
                <br><br>
            </c:forEach>
            <a href="/movie/logout.htm">Logout</a>
</body>
</html>