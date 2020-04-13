<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	add alien
	<form action="addAlien">
		id: <input type="text" name="aid"><br>
		name: <input type="text" name="aname"><br>
		tech: <input type="text" name="tech"><br>
		<input type="submit"><br>
	</form>
	<br/>
	find alien by id
	<form action="getAlien">
		<input type="text" name="aid"><br>
		<input type="submit"><br>
	</form>
	<br/>
	find alien by tech
	<form action="getAlienByTech">
		<input type="text" name="tech"><br>
		<input type="submit"><br>
	</form>
	<br/>
	list all aliens
	<form action="getAllAliens">
		<input type="submit"><br>
	</form>
</body>
</html>