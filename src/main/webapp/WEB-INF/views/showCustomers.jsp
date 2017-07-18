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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/showCustomers.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/loginpage.jsp"></jsp:include>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Imię</th>
				<th>Nazwisko</th>
				<th>Numer telefonu</th>
				<th>Edycja</th>
				<th>Usuwanie</th>
			</tr>
			
			<c:forEach var="customer" items="${list }">
				<tr>
					<td>${customer.customerID }</td>
					<td>${customer.firstName }</td>
					<td>${customer.secondName }</td>
					<td>${customer.phoneNumber }</td>
					<td><a class="button" href="editCustomer/${customer.customerID }">Edytuj</a></td>
					<td><a class="button" href="deleteCustomer/${customer.customerID }">Usuń</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>