<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Film Query</title>
</head>
<body>
	<form action="getFilm.do" method="GET">
		Film ID: <input type="text" name="fid" /> <input type="submit"
			value="Show Film" />
	</form>
	<hr>
	<ul>
		<c:forEach var="f" items="${films}">
			<li><a href="getFilm.do?fid=${f.id}">${f.title}</a></li>
		</c:forEach>


	</ul>

</body>
</html>