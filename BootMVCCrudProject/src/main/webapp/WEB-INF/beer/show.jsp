<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Beer</title>
<link rel="stylesheet" href="/css/beer_styles.css">
</head>
<body>
<div id="main">
	<div>
		<h2>${beer.name}(${beer.type})</h2>
		<h3><a href="${beer.brewery.website}"><span title="Linked">${beer.brewery.name}</span></a></h3>
		<h4>Abv. ${beer.abv}%</h4>
	<hr>
		<h5>Description:</h5>
		<p>${beer.description}</p>
		<br>
		<p>${beer.notes}</p>
	</div>
	<hr>
	<form action="/" method="GET">
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
	</div>
</body>
</html>