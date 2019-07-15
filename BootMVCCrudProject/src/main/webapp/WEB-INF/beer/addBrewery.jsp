<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add A Brewery</title>
<link rel="stylesheet" href="/css/beer_styles.css">
</head>
<body>
<hr>
<div id="add" class= "add-body">
<h3 id="add-header">Add a Brewery!</h3>
  <form action="getAddedBrewery.do" method="GET">
		<label for="name">* Name:</label>
		<input type="text" name="name">
		<br>
		<label for="website">Website:</label>
		<input type="text" name="website">
		<br>
		<label for="yearEstablished">Year Established:</label>
		<input type="text" name="yearEstablished">
		<br>
		<label for="city">City:</label>
		<input type="text" name="city">
		<br>
		<label for="state">State:</label>
		<input type="text" name="state">
		<br>
		<label for="address">Address:</label>
		<input type="text" name="address">
		<br>
		<label for="country">Country:</label>
		<input type="text" name="country">
		<br>
		<label for="notes">Notes:</label>
		<input type="text" name="notes">
		<br>
		<button type="submit" name=submit-btn>Add Brewery</button>
	</form>
	<p>* Must Have a Valid Entry</p>
	<hr>
	<form action="/" method="GET">
		<input type="submit" value="Home" />
	</form>
</div>
</body>
</html>