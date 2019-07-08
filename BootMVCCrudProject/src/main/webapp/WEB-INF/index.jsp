<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Some Beer</title>
<style>
body {
	background-color: #6699ff;
	text-align: center;
}

title {
	text-align: center
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<form action="getBeer.do" method="GET">
		Beer ID: <input type="text" name="fid" /> <input type="submit"
			value="Show Beer" />
	</form>
	<hr>
	<form action="getBeerAdd.do" method="GET">
		<input type="submit" value="Add One to the List" />
	</form>
	<hr>
	<h3>Current List:</h3>
	<br>
	<ul>
		<c:forEach var="b" items="${beers}">
			<li><a href="getBeer.do?fid=${b.id}">${b.name}</a></li>
		</c:forEach>
	</ul>
</body>
</html>