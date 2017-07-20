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
				<th>Marka</th>
				<th>Model</th>
				<th>Rok produkcji</th>
				<th>Edycja</th>
				<th>Usuwanie</th>
			</tr>
			
			<c:forEach var="car" items="${list }">
				<tr>
					<td>${car.carID }</td>
					<td>${car.brand }</td>
					<td>${car.model }</td>
					<td>${car.year }</td>
					<td><a class="button" href="editCar/${car.carID }">Edytuj</a></td>
					<td><a class="button" href="deleteCar/${car.carID }">Usuń</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>