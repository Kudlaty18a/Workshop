<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Warsztat</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" />
</head>
<body>
	<form action="login.html" method="post">
		Użytkownik: </br>
		<input id="fields" type="text" name="username"/><br/>  
		Hasło: </br>
		<input id="fields" type="password" name="password"/><br/></br>
		<input class="button" type="submit" value="login"/>  
	</form>  
</body>
</html>