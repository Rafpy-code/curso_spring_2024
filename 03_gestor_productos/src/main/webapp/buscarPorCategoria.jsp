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
<title>Lista de productos por categoría</title>
<link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
	<div>
		<h1>Lista de productos por categoría</h1>
		<form action="buscarPorCategoria" method="get">
			<input type="text" name="categoria"
				placeholder="Categoría del producto"> <input type="submit"
				value="Mostrar">
		</form>
	</div>
</body>
</html> 