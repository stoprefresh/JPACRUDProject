<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Beer</title>
<style>
body {background-color: #336699; 
	  text-align: center;
}
title {text-align: center }

</style>
</head>
<body>
<h3>Update this Beer!</h3>
<hr>
<form action="getUpdated.do" method="GET">
	    <input type="hidden" name="fid" value="${beer.id}"/>
		<label for="name">Name:</label>
		<input type="text" name="name" value="${beer.name}">
		<br>
		<label for="type" >Type:</label>
		<input type="text" name="type" value="${beer.type}"></input>
		<br>
		<label for="abv" >ABV:</label>
		<input type="number" name="abv" value="${beer.abv}">
		<br>
		<label for="brewery" >Brewery:</label>
		<input type="text" name="brewery" value="${beer.brewery}">
		<br>
		<label for="description" >Description:</label>
		<input type="text" name="description" value="${beer.description}">
		<br>
		<label for="notes">Notes:</label>
		<input type="text" name="notes" value="${beer.notes}">
		<br>
		<br>
		<button type="submit" name=submit-btn>Update Beer</button>
	</form>
	<form action="getHome.do" method="GET">
		<input type="submit" value="Home" />
	</form>

</body>
</html>