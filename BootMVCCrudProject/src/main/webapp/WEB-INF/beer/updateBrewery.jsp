<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Beer</title>
<link rel="stylesheet" href="/css/beer_styles.css">
</head>
<body>
<div id="main">
<h3>Update this Brewery!</h3>
<hr>
<form action="getBreweryUpdated.do" method="GET">
        <input type="hidden" name="fid" value="${brewery.id}"/>
	    <label for="name">Name:</label>
		<input type="text" name="name" value="${brewery.name}">
		<br>
		<label for="website">Website:</label>
		<input type="text" name="website" value="${brewery.website}">
		<br>
		<label for="yearEstablished">Year Established:</label>
		<input type="text" name="yearEstablished" value="${brewery.yearEstablished}">
		<br>
		<label for="city">City:</label>
		<input type="text" name="city" value="${brewery.city}">
		<br>
		<label for="state">State:</label>
		<input type="text" name="state" value="${brewery.state}">
		<br>
		<label for="address">Address:</label>
		<input type="text" name="address" value="${brewery.address}">
		<br>
		<label for="country">Country:</label>
		<input type="text" name="country" value="${brewery.country}">
		<br>
		<label for="notes">Notes:</label>
		<input type="text" name="notes" value="${brewery.notes}">
		<br>
		<button type="submit" name=submit-btn>Update Brewery</button>
	</form>
	<hr>
	<form action="/" method="GET">
		<input type="submit" value="Home" />
	</form>
</div>
</body>
</html>