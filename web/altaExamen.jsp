<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:useBean id="uc" class="Controlador.UsuariosController"/>
<jsp:useBean id="mc" class="Controlador.MateriasController"/>
<!DOCTYPE html>
<html>
    
	<c:choose>
	<c:when test="${sessionScope.usuario.class.name == 'Modelo.Profesor'}">
	
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Foodle</title>
		</head>
		<body>
			<form method="post" action="r">
				
				
				<input type="submit" />
			</form>
		</body>
	</c:when>
	<c:otherwise>
		<c:redirect url = "/"/>
	</c:otherwise>
	
</c:choose>
</html>