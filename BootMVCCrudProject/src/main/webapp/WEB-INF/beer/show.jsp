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
<div>
	<div>
		<h2><u>${beer.name}(${beer.type})</u></h2>
		<h3>${beer.brewery}</h3>
		<h4>${beer.abv}%</h4>
		<h5><u>Description:</u></h5>
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
	</div>
</body>
</html>