<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Warsztat</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginpage.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/addCustomers.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/loginpage.jsp"></jsp:include>
	<div>
		<h1>Dodaj samochód</h1>
		<form:form method="post" action="saveCar">
			<p>Marka :</p>
			<form:input path="brand" /></br>
			<p>Model :</p>
			<form:input path="model" /></br>
			<p>Rok produkcji :</p>
			<form:input path="year" /></br>
			<input type="submit" value="Zapisz" />
		</form:form>
	</div>
</body>
</html>