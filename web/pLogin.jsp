<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="css/styles.css" />
	<c:choose>
	<c:when test="${sessionScope.usuario.class.name == 'Modelo.Profesor'}">
	
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Foodle</title>
		</head>
		<body id="plogin">
			<article class="container">
				<div class="row">
					<a href="altaAlumno.jsp" class="col-sm-6">Dar de alta a alumno</a>
					<a href="matriculaAlumnos.jsp" class="col-sm-6">Matricular a alumno</a>
				</div>
				<div class="row">
					<form action="" class="col-sm-6">
						<input type="text" name="materia" /><br />
						<label for="alta" class="link">Alta materia</label>
						<input type="submit" class="hidden" name="alta" id="alta" />
					</form>
					<a href="altaExamen.jsp"  class="col-sm-6">Crear ex&aacute;men</a>
				</div>
				
				<div class="row">
					<a href="comprobarExamen.jsp" class="col-sm-6">Evaluar ex&aacute;men</a>
					<a href="comprobarNotasAlumno.jsp" class="col-sm-6">Consultar calificaciones de un alumno en concreto en una materia</a>
				</div>
				
				
				<div class="row">
					<a href="comprobarNotasMateria.jsp" class="col-sm-12">Consultar las calificaciones de todos los alumnos de una materia determinada</a>			
				</div>
			
			</article>
			
		</body>		
	</c:when>
	<c:otherwise>
		<c:redirect url = "/"/>
	</c:otherwise>
	
</c:choose>
</html>