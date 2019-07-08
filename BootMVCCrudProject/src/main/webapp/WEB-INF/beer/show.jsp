<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h5>Description</h5>
		<p>${beer.description}</p>
		<br>
		<p>${beer.notes}</p>
	</div>
	<form action="getHome.do" method="GET">
		<input type="submit" value="Home" />
	</form>
	<form action="getBeerUpdate.do" method="GET">
		<input type="hidden" name="fid" value="${beer.id}"/>
		<input  type="submit" value="Update" />
	</form>
	<form action="getBeerDelete.do" method="GET">
	    <input type="hidden" name="fid" value="${beer.id}"/>
		<input type="submit" value="Delete" />
	</form>
</body>
</html>