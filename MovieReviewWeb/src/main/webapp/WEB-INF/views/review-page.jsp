<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
			 	<b>Title:</b> <c:out value="${movie.getName()}"/><br>
                <b>Actor:</b> <c:out value="${movie.getActor()}"/><br>
                <b>Actress:</b> <c:out value="${movie.getActress()}"/><br>
                <b>Genre:</b> <c:out value="${movie.getGenre()}"/><br>
                <b>Year:</b> <c:out value="${movie.getYear()}"/><br><br>
                 
                 <b>Average Rating:</b> <c:out value="${avgRating}"/><br><br>
                 
                <c:forEach var="review" items="${movie.getReviews()}">
                	Comment : <c:out value="${review.getComment()}"/><br>
                	Rating  : <c:out value="${review.getStar()}"/><br>
                </c:forEach> 
                <br><br>

                <form action='/movie/movie/addreview.htm?id=${movie.getMovieId()}' method="post">
				Comment : <input type="text" name="comment" required="required"/>  <br/>
				Rating : <select name="star">
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
					</select>
				<input type="submit" name="Post"/>
				</form>
<a href="/movie/logout.htm">Logout</a>
</body>
</html>