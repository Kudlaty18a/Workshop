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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/showServices.css" />
</head>
<body>
	<jsp:include page="/WEB-INF/views/loginpage.jsp"></jsp:include>
	<div>
		<table>
			<tr>
				<th>ID</th>
				<th>Numer rejestracyjny</th>
				<th>Pojazd</th>
				<th>Klient</th>
				<th>Numer telefonu</th>
				<th>Kwota</th>
				<th>Edycja</th>
				<th>Usuwanie</th>
				<th>Dodaj akcję</th>
			</tr>
			
			<c:forEach var="s" items="${list }">
				<tr>
					<td>${s.serviceID }</td>
					<td><a class="button" href="showActions/${s.serviceID }">${s.registrationNumber }</a></td>
					<td>${s.brand } ${s.model } ${s.year }</td>
					<td>${s.firstName } ${s.secondName }</td>
					<td>${s.phoneNumber }</td>
					<td>${s.price }</td>
					<td><a class="button" href="editService/${s.serviceID }">Edytuj</a></td>
					<td><a class="button" href="deleteService/${s.serviceID }" 
						onclick="return confirm('Usuwając tą usługę spowodujesz usunięcie wszystkich akcji, które są z nią powiązane. Czy na pewno chcesz kontynuować?')">Usuń</a></td>
					<td><a class="button" href="addAction/${s.serviceID }">Dodaj działanie</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>