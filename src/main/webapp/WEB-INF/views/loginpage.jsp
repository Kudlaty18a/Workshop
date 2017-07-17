<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Warsztat</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginpage.css" />
</head>
<body>
	<ul>
		<li><a class="active" href="redirect:loginpage.html">Strona główna</a></li>
		<li><a href="addservice.html">Dodaj usługę</a></li>
		<li><a href="showservices.html">Wyświetl usługi</a></li>
		<li class="logout_button"><a href="logout.html">Wyloguj</a></li>
	</ul>
</body>
</html>