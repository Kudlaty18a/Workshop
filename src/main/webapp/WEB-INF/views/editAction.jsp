<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Warsztat</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addCustomers.css" />
</head>
<body>
	<div>
		<h1>Dodaj akcję</h1>
		<form:form method="POST" action="/app/editSaveAction">
			<form:hidden  path="actionHistoryID" />
			<p>Operacja :</p>
			<form:input path="operation" /></br>
			<p>Kwota :</p>
			<form:input path="price" /></br>
			<input type="submit" value="Zapisz" />
		</form:form>
	</div>
</body>
</html>