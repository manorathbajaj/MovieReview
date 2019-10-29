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
	 <c:forEach var="movie" items="${requestScope.movieList}">

                <b>Title:</b> <c:out value="${movie.getName()}"/><br>
                <b>Actor:</b> <c:out value="${movie.getActor()}"/><br>
                <b>Actress:</b> <c:out value="${movie.getActress()}"/><br>
                <b>Genre:</b> <c:out value="${movie.getGenre()}"/><br>
                <b>Year:</b> <c:out value="${movie.getYear()}"/><br>
 <!--           <b>Id:</b> <c:out value="${movie.getMovieId()}"/><br> --> 
                <a href='/movie/movie/addreview.htm?id=${movie.getMovieId()}' >Reviews</a>	
                <br><br>
            </c:forEach>
	
<a href="/movie/logout.htm">Logout</a>
</body>
</html>