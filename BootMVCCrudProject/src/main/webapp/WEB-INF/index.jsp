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
	<form action="getBeer.do" method="GET">
		Beer ID: <input type="text" name="fid" /> <input type="submit"
			value="Show Beer" />
	</form>
	<hr>
	<ul>
		<c:forEach var="b" items="${beers}">
			<li><a href="getBeer.do?fid=${b.id}">${b.name}</a></li>
		</c:forEach>


	</ul>

</body>
</html>