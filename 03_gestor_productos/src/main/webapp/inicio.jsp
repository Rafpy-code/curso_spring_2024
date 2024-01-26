<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="models.Producto, java.util.List"%> 
<%@taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 
<title>Gestor de Productos</title>
<link rel="stylesheet" type="text/css" href="../estilos.css">
</head>
<body>
	<div>
		<h1>Gestor de Productos</h1>
		<a href="toAlta">Nuevo producto</a> 
		<a href="toBuscarPorCategoria">Productos por categoría</a> 
		<a href="toEliminar">Eliminar producto</a>
	</div>
</body>
</html> 
