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
			<c:forEach var="critic" items="${critics}">
			<b>Critic Name :</b> <c:out value="${critic.getfName()}"/><br><br>
			<c:forEach var="review" items="${critic.getReviews()}">
				<b>Movie Name :</b> <c:out value="${review.getMovie().getName()}"/><br>
				<b>Rating</b> :<c:out value="${review.getStar()}"/><br>
				<b>Comment</b> :<c:out value="${review.getComment()}"/><br>
				<br><br>	
			</c:forEach>
              <br><br>	<br><br>	
            </c:forEach>
<a href="/movie/logout.htm">Logout</a>
</body>
</html>