<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Film</title>
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
	<div>
		<h2>${beer.name}(${beer.type})</h2>
		<h3>${beer.brewery}</h3>
		<h4>${beer.abv}%</h4>
		<p>${beer.description}</p>
	</div>
	<form action="getHome.do" method="GET">
		<input type="submit" value="Home" />
	</form>
	<form action="getBeerUpdate.do?fid=${b.id}" method="GET">
		<input type="submit" value="Update" />
	</form>
	<form action="getBeer.do?fid=${b.id}" method="GET">
		<input type="submit" value="Delete" />
	</form>
</body>
</html>