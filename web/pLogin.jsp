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
			<a href="altaAlumno.jsp">Dar de alta a alumno</a>
			<a href="matriculaAlumnos.jsp">Matricular a alumno</a>
			<a href="altaMateria.jsp">Alta materia</a>
			<a href="altaExamen.jsp">Crear ex&aacute;men</a>
			<a href="comprobarExamen.jsp">Evaluar ex&aacute;men</a>
			<a href="comprobarNotasAlumno.jsp">Consultar calificaciones de un alumno en concreto en una materia</a>
			<a href="comprobarNotasMateria.jsp">Consultar las calificaciones de todos los alumnos de una materia determinada</a>			
			
		</body>		
	</c:when>
	<c:otherwise>
		<c:redirect url = "/"/>
	</c:otherwise>
	
</c:choose>
</html>