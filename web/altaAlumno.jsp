<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

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
					
				<p>Login*:&nbsp;&nbsp;<input type="text" name="login"/></p>
				<p>Contrase&ntilde;a*:&nbsp;&nbsp;<input type="pass" name="pass"></p>
				<p>Nombre*:&nbsp;&nbsp;<input type="text" name="name" /></p>
				<p>Descripci&oacute;n:&nbsp;&nbsp;<input type="textarea" name="desc" /></p>
				<p>Edad:&nbsp;&nbsp;<input type="number" name="edad"></p>
				<p>Curso:&nbsp;&nbsp;<input type="text" name="curso" /></p>
				<input type="submit" value="Dar de alta" name="alta" />
				<input type="reset" value="Reinicializar" />
				
			</form>
		</body>
	</c:when>
	<c:otherwise>
		<c:redirect url = "/"/>
	</c:otherwise>
	
</c:choose>
</html>