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
			<div method="post" action="r" class="container">
				
				<div class="row">
					<form id="lista" class="col-sm-6 col-xs-12 container" >
						<input type="submit" value="Crear nuevo ex&aacute;men" class="row"/>
						
					</form>

					<form id="alta" class="col-sm-6 col-xs-12 container" >
						<h5 class="row">Pregunta:&nbsp;<input type="text" name="pregunta" /></h5>
						<input type="checkbox" name="desordenar" />&nbsp;&nbsp;<label for="desordenar">Desordenar preguntas y respuestas aleatoriamente durante el examen</label> 
						<input type="file" name="imagen" class="row" /> <br />
						<table class="row container">
							<tr class="row">
								<th class="id">#</th>
								<th class="ans">Respuesta</th>
								<th class="val">Valoraci&oacute;n</th>
							</tr>
							<tr class="row respuestas">
								<td class="id">1</td>
								<td class="ans"><input type="text" class="respuesta" name="respuesta1"></td>
								<td class="val"><input type="number" step="any" class="valor" name="valor1"></td>
							</tr>
						</table>
						
						<input type="button" onclick="agregarCampo()" value="Agregar Respuesta">
						<input type="submit" value="Agregar pregunta" />
						
					</form>
				</div>
				
				
			</form>
		</body>
	</c:when>
	<c:otherwise>
		<c:redirect url = "/"/>
	</c:otherwise>
	
</c:choose>
</html>