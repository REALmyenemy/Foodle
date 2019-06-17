<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<jsp:useBean id="uc" class="Controlador.UsuariosController"/>
<!DOCTYPE html>
<html>
    
	<c:choose>
	<c:when test="${sessionScope.usuario.class.name == 'Modelo.Profesor'}">
	
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Foodle</title>
		</head>
		<body>
			<form method="post" action="/r">
				<a href="pLogin.jsp" style="color:red;"> < Volver </a>
				<c:if test="${sessionScope.mensajeError!=''}">
					<p style="color:red;">
						<c:out value="${sessionScope.mensajeError}"></c:out>
					</p>
				</c:if>
			<select multiple="multiple" name="alumnos">
				<c:set var="lista" value="${uc.getAlumnos()}"/>
				<c:forEach items="${lista}" var="alumno" >
					<option value="${alumno.numero}">
						<c:out value="${alumno.nombre}"></c:out>
					</option>
				</c:forEach>
			</select>
			</form>
		</body>
	</c:when>
	<c:otherwise>
		<c:redirect url = "/"/>
	</c:otherwise>
	
</c:choose>
</html>