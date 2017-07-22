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
		<h1>Dodaj klienta</h1>
		<form:form method="post" action="saveCustomer">
			<p>Imię :</p>
			<form:input path="firstName" /></br>
			<p>Nazwisko :</p>
			<form:input path="secondName" /></br>
			<p>Numer telefonu :</p>
			<form:input path="phoneNumber" /></br>
			<input type="submit" value="Zapisz" />
		</form:form>
	</div>
</body>
</html>