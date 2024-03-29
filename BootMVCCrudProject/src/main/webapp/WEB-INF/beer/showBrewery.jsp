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
		<h2><a href="${brewery.website}"><span title="Linked">${brewery.name}</span></a></h2>
		<h3>${brewery.city}, ${brewery.state}</h3>
		<h3>${brewery.country}</h3>
		<hr>
		<h4>Est. ${brewery.yearEstablished}</h4>
	</div>
		<hr>
	<form action="/" method="GET">
		<input type="submit" value="Home" />
	</form>
	<form action="getBreweryUpdate.do" method="GET">
		<input type="hidden" name="fid" value="${brewery.id}"/>
		<input  type="submit" value="Update" />
	</form>
	<form action="getBreweryDelete.do" method="GET">
	    <input type="hidden" name="fid" value="${brewery.id}"/>
		<input type="submit" value="Delete" />
	</form>
	<br>
	<h4>Beers from this Brewery:</h4>
		<ul>
			<c:forEach var="br" items="${brewery.beers}">
				<li><a href="getBeer.do?fid=${br.id}">${br.name}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>