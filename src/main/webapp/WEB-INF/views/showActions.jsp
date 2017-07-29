<%@page language="Java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Warsztat</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/showActions.css" />
</head>
<body>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Numer rejestracyjny</th>
				<th>Pojazd</th>
				<th>Klient</th>
				<th>Numer telefonu</th>
				<th>Kwota</th>
				<th rowspan="3">Edytuj</th>
				<th rowspan="3">Usuń</th>
			</tr>
			
			<tr id="static_row">
				<td>${service.serviceID }</td>
				<td>${service.registrationNumber }</td>
				<td>${car.brand } ${car.model } ${car.year }</td>
				<td>${customer.firstName } ${customer.secondName }</td>
				<td>${customer.phoneNumber }</td>
				<td>${service.price }</td>
			</tr>
			
			<tr>
				<th>ID</th>
				<th colspan="3">Operacja</th>
				<th>Data</th>
				<th>Kwota</th>
			</tr>
			
			<c:forEach var="a" items="${listOfActions }" varStatus="count">
				<tr>
					<td>${count.count }</td>
					<td colspan="3">${a.operation }</td>
					<td>${a.actionDate }</td> 
					<td>${a.price }</td>
					<td><a class="button" href="/app/editAction/${a.actionHistoryID }">Edytuj</a></td>
					<td><a class="button" href="/app/deleteAction/${a.actionHistoryID }">Usuń</a></td>
				</tr>
			</c:forEach>
			<tr id="static_row">
				<td colspan="4"></td>
				<td>Zarobek:</td>
				<c:choose>
					<c:when test="${result > 0}">
						<td id="green_color">${result }</td>
					</c:when>
					<c:otherwise>
						<td id="red_color">${result }</td>
					</c:otherwise>
				</c:choose>
				<td></td>
				<td></td>
			</tr>
		</table>
	</div>
</body>
</html>