<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Warsztat</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/logoutIndex.css" />
</head>
<body>
	<jsp:include page="/index.jsp"></jsp:include>
	<p id="message">Wylogowanie pomyślne</p>
</body>
</html>