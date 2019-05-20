<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%--<sql:setDataSource var = "snapshot"
		driver = "com.mysql.jdbc.Driver"
        url = "jdbc:mysql://localhost/foodle"
        user = "root"  password = ""/>--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foodle</title>
		<style>
			body
			{
				background-color:darkgray;
			}
			form
			{
				margin-left:30%;
				margin-right:30%;
				margin-top:10%;
				width:29%;
				padding: 5%;
				border:solid 1px black;
				border-radius: 5px;
				padding-bottom:4%;
			}
			button
			{
				float:right;
			}
			input[type="text"],input[type="password"]
			{
				width:70%;
			}
		</style>
    </head>
    <body>
		<form method='post' action='r'>
			<label for='user'>Usuario: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input id='user' name='user' type='text' /> <br/><br/>
			<label for='pass'>Contrase&ntilde;a: </label><input id='pass' name='pass' type='password' /> <br/><br/>
			<input type='submit' name="login" value='Conectar'>
		</form>
    </body>
</html>
