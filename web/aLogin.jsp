<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    
	<c:choose>
	<c:when test="${sessionScope.usuario.class.name == 'Modelo.Alumno'}">
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Foodle</title>
		</head>
		<body>
			
		</body>
		
	</c:when>
	<c:otherwise>
		<c:redirect url = "/"/>
	</c:otherwise>
	
</c:choose>
</html>
