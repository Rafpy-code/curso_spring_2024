<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Buscador</title>
<link rel="stylesheet" type="text/css" href="estilos.css" />
</head>
<body>
	<div class="campos">
		<form action="buscar" class="formulario" method="get">
			<h2>Buscador temático</h2>
			<p>
				<input type="text" name="tematica" placeholder="Temática a buscar" />
			</p>
			<br>
			<p>
				<input type="submit" value="Buscar" />
			</p>
			<br>
		</form>
		<br> <a href="toBuscar">VOLVER</a>
	</div>
</body>
</html>