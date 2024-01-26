<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="models.Producto, java.util.List"%> <%@taglib
uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 
<title>Crear Producto</title>
<link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
	<div>
		<h1>Añadir nuevo producto</h1>
		<form action="alta" method="post">
			<input type="text" name="nombre" placeholder="Nombre del producto">
			<input type="text" name="precio" placeholder="Precio del producto 35.72"> 
			<input type="text" name="categoria" placeholder="Categoría del producto"> 
			<input type="submit" value="Añadir">
		</form>
	</div>
</body>
</html>