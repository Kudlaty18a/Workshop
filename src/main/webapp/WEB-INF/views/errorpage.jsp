<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pl-PL">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Warsztat</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/errorpage.css" />
</head>
<body>
	<jsp:include page="/index.jsp"></jsp:include>
	<p id="error_message">Błędny login lub hasło</p>
</body>
</html>