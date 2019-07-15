<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add A Beer</title>

<link rel="stylesheet" href="/css/beer_styles.css">

</head>
<body>

<hr>
<div id="add" class= "add-body">
<h3 id="add-header">Add a Beer!</h3>
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
		<label>Brewery:</label>
		<select name="category">
    		<c:forEach items="${listCategory}" var="category">
        		<option value="${category.id}">${category.name}</option>
   			</c:forEach>
		</select>
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
</div>

</body>

</html>