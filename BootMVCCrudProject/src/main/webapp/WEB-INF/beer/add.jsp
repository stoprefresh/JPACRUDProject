<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add A Beer</title>
<style>
body {background-color: #336699; 
	  text-align: center;
}
title {text-align: center }

</style>
</head>
<body>
<h3>Add a Beer!</h3>
<hr>
<form action="getAdded.do" method="GET">
		<label for="name">Name:</label>
		<input type="text" name="name">
		<br>
		<label for="type">Type:</label>
		<input type="text" name="type"></input>
		<br>
		<label for="abv">ABV:</label>
		<input type="number" name="abv">
		<br>
		<label for="brewery">Brewery:</label>
		<input type="text" name="brewery">
		<br>
		<label for="description">Description:</label>
		<input type="text" name="description">
		<br>
		<label for="notes">Notes:</label>
		<input type="text" name="notes">
		<br>
		<br>
		<button type="submit" name=submit-btn>Add Beer</button>
	</form>
	<form action="getHome.do" method="GET">
		<input type="submit" value="Home" />
	</form>

</body>
</html>