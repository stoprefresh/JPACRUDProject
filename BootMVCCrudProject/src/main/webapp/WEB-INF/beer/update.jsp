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
		<input type="number" name="abv" value="${beer.abv}" step=0.01>
		<br>
		<label for="brewery">Brewery:</label>
		<select name="brewery">
    	<c:forEach var="br" items="${breweries}">
    	<c:if test="${br.name != 'Default'}">
        <option value="${br.id}">${br.name}</option>
        </c:if>
    	</c:forEach>
		</select>
		<br>
		<label for="description" >Description:</label>
		<input type="text" name="description" value="${beer.description}" style='width:100%'>
		<br>
		<label for="notes">Notes:</label>
		<input type="text" name="notes" value="${beer.notes}">
		<br>
		<br>
		<button type="submit" name=submit-btn>Update Beer</button>
	</form>
	<hr>
	<form action="/" method="GET">
		<input type="submit" value="Home" />
	</form>
</div>
</body>
</html>