<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Alta</title>
</head>
<body>
	<div>
		<h1>Añadir nueva temática</h1>
		<form action="alta" method="post">
			<p>
				<input type="text" name="url" placeholder="URL">
			</p><br>
			<p>
				<input type="text" name="tematica" placeholder="¿Cúal es la temática?">
			</p><br>
			<p>
				<input type="text" name="descipcion" placeholder="Descripción"> 
			</p><br>
			<p>
				<input type="submit" value="Añadir"> 
			</p><br>				
		</form>
		<br>
		<a href="toBuscar">VOLVER</a>
	</div>	
</body>
</html>