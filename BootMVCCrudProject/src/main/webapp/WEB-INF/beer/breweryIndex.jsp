<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Breweries</title>
<link rel="stylesheet" href="/css/beer_styles.css">
</head>
<body>

<br>
	<div id="main" class="main-body">
	
		<form action="getBrewery.do" method="GET">
			Beer ID: <input type="text" name="fid" /> <input type="submit"
				value="Show Brewery" />
		</form>
		<hr>
		<form action="getBreweryAdd.do" method="GET">
			<input type="submit" value="Add One to the List" />
		</form>
		<hr>
		<h3>Current Breweries Archived:</h3>
		<br>
		<ul>
			<c:forEach var="br" items="${breweries}">
				<li><a href="getBrewery.do?fid=${br.id}">${br.name}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>