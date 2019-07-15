<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Beers</title>
<link rel="stylesheet" href="/css/beer_styles.css">
</head>
<body>
	<br>
	<div id="main">
		<form action="getBeer.do" method="GET">
			Beer ID: <input type="text" name="fid" /> <input type="submit"
				value="Show Beer" />
		</form>
		<hr>
		<form action="getBeerAdd.do" method="GET">
			<input type="submit" value="Add A Beer" />
		</form>
		<hr>
		<form action="/" method="GET">
			<input type="submit" value="Home" />
		</form>
		<hr id="databreak">
		<h3>Current Beer List:</h3>
		<br>
		<ul>
			<c:forEach var="b" items="${beers}">
				<li><a href="getBeer.do?fid=${b.id}">${b.name}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>