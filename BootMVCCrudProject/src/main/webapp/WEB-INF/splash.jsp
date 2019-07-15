<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Beers/Breweries</title>
<link rel="stylesheet" href="/css/beer_styles.css">
</head>
<body>
<br>
	<div id="main" class="main-body">
	<h2>View and Search</h2>
	<p>This is an application intended to record Beers and Breweries that I have found over the years</p>
	<hr>
		<form action="getBeerIndex.do" method="GET">
			<input type="submit" value="View Listed Beers" />
		</form>
		<hr>
	<form action="getBreweryIndex.do" method="GET">
			<input type="submit" value="View Listed Breweries" />
		</form>
		<hr>
	</div>
</body>
</html>