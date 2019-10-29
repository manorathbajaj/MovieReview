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
Search :
<form:form action="/movie/movie/search.htm" method="Post">
            <label for="keyword"><b>Keyword</b></label>
            <input type="text" placeholder="Keyword" name="keyword" required><br><br>
            <label for="criteria"></label>
            <input type="radio" name="criteria" value ="name" required>Search by Title<br>
            <input type="radio" name="criteria" value ="actor">Search by Actor<br>
            <input type="radio" name="criteria" value ="actress">Search by Actress<br>
            <input type="radio" name="criteria" value ="genre">Search by Actress<br>
            <input type="submit" name="submit" value="Search Movies">
        </form:form>
</body>
</html>