<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="models.Producto, java.util.List"%> <%@taglib
uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 
<title>Gestor de Productos</title>
<style type="text/css">
body{
color:purple;
}
h1{
text-align: center;
}
div {
	width: 400px;
	margin: 50px auto;
	padding: 15px;
	background-color: smocke;
	border: 1px solid purple;
}

a {
	display: block;
	width:60%;
	border: 1px solid purple; 
	margin: 0 auto;
	margin-bottom : 20px;
	padding: 15px;
	margin-bottom: 20px;
	text-decoration: none;
}
a:hover {
	background: purple;
	color:white;
}
</style>
</head>
<body>
	<div>
		<h1>Gestor de Productos</h1>
		<a href="toAlta">Nuevo producto</a> 
		<a href="toBuscarProducto">Buscar producto</a>
		<a href="toBuscarPorCategoria">Productos por categorÃ­a</a> 
		<a href="toEliminar">Eliminar producto</a>
	</div>
</body>
</html> 
