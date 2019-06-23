<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="ec" class="Controlador.ExamenController"/>
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
			<c:set var="pendientes" target="${ec.examenesPendientes(sessionScope.usuario)}"  ></c:set>
			<c:forEach var="examen" items="pendientes">
				<form class="row" action="test.jsp" method="post">
					<div class="col-xs-4">
						<c:out value="${examen.materia}"></c:out>
					</div>
					<div class="col-xs-4">
						<input type="submit" id="exId" name="exId" value="<c:out value="${examen.id}"></c:out>" class="hidden">
					</div>
					<div class="col-xs-4">
						<label for="exId">Empezar ex&aacute;men</label>
					</div>
				</form>
				
			</c:forEach> 

		</body>
		
	</c:when>
	<c:otherwise>
		<c:redirect url = "/"/>
	</c:otherwise>
	
</c:choose>
</html>
