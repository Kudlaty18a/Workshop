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
		<h1>Edytuj usługę</h1>
		<form:form method="POST" action="/app/editSaveService">
			<form:hidden  path="serviceID" />
			<p>Numer rejestracyjny pojazdu :</p>
			<form:input path="registrationNumber" /></br>
			<p>Koszt usługi :</p>
			<form:input path="price" /></br>
			<p>Wybierz pojazd :</p>
			<form:select path="carID" name="car">
				<c:forEach var="showCar" items="${listOfCars }">
					<option value="${showCar.carID }">${showCar.brand } ${showCar.model }</option>
				</c:forEach>
			</form:select></br>
			<p>Wybierz klienta</p>
			<form:select path="customerID" name="customer">
				<c:forEach var="showCustomer" items="${listOfCustomers }">
					<option value="${showCustomer.customerID }">${showCustomer.firstName } ${showCustomer.secondName }</option>
				</c:forEach>
			</form:select></br>
			<input type="submit" value="Zapisz" />
		</form:form>
	</div>
</body>
</html>