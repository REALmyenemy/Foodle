<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<jsp:useBean id="mc" class="Controlador.MateriasController"/>
<!DOCTYPE html>
<html>
    
	<c:choose>
	<c:when test="${sessionScope.usuario.class.name == 'Modelo.Profesor'}">
	
		<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Foodle</title>
			<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
			<link rel="stylesheet" type="text/css" href="css/styles.css" />
			<script src="js/functions.js" ></script>
		</head>
		<body id="altaExamen">
			<div class="container">
				
				<div class="row">
					<form id="alta" class="col-sm-6 col-xs-12 container" action="ExamenServlet" method="post"  enctype="multipart/form-data" >
						<p>Materia:&nbsp<select name="materia">
							<c:set var="materias" value="${mc.getMaterias(sessionScope.usuario)}"/>
							<c:forEach items="${materias}" var="materia" >
								<option value="${materia.id}">
									<c:out value="${materia.nombre}"></c:out>
								</option>
							</c:forEach>
							</select></p>
						<input type="checkbox" name="desordenar" />&nbsp;&nbsp;<label for="desordenar">Desordenar preguntas y respuestas aleatoriamente durante el examen</label> 
						<input type="submit" value="Crear nuevo exámen" class="row" name="submit"/>
						<c:forEach items="${sessionScope.preguntas}" var="pregunta" >
							<h3><c:out value="${pregunta.pregunta}"></c:out></h3>
						</c:forEach>
					</form>

					<form id="alta" class="col-sm-6 col-xs-12 container" action="ExamenServlet" method="post" enctype="multipart/form-data" >
						<h5 class="row">Pregunta:&nbsp;<input type="text" name="pregunta" /></h5>
						
						<input type="file" name="imagen" class="row" /> <br />
						<table class="row container">
							<tr class="row">
								<th class="id">#</th>
								<th class="ans">Respuesta</th>
								<th class="val">Si se marca</th>
								<th class="val">Si no se marca</th>
							</tr>
							<tr class="row respuestas">
								<td class="id">1</td>
								<td class="ans"><input type="text" class="respuesta" name="respuesta1"></td>
								<td class="val"><input type="number" step="any" class="valor" name="valor1"></td>
								<td class="val"><input type="number" step="any" class="valor" name="nega1"></td>
							</tr>
						</table>
						<div name="agregarPregunta" value="agregarPregunta" class="hidden"></div>
						<input type="button" onclick="agregarCampo()" value="Agregar Respuesta">
						<input type="submit" value="Agregar pregunta" name="submit" />
						
					</form>
				</div>
				
				
		
		</body>
	</c:when>
	<c:otherwise>
		<c:redirect url = "/"/>
	</c:otherwise>
	
</c:choose>
</html>