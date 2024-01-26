<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="models.Producto, java.util.List"%>
<%@taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Last-Modified" content="0" />
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta charset="utf-8" />
<title>Lista</title>
<link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body>
	<h2>Productos de ${param.categoria}</h2>
	<table border="1">
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
		<c:forEach var="producto" items="${productos}">
			<tr>
				<td>${producto.nombre}</td>
				<td>${producto.precio}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="toInicio">INICIO</a>
</body>
</html>
