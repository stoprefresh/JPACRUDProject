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
	<hr>
		<form action="getBeerAdd.do" method="GET">
			<input type="submit" value="Add One to the List" />
		</form>
		<hr>
	<form action="getBeerAdd.do" method="GET">
			<input type="submit" value="Add One to the List" />
		</form>
		<hr>
	
	</div>
</body>
</html>