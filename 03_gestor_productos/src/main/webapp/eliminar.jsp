<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8" import="models.Producto, java.util.List"%> <%@taglib
uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache"> 
<meta charset="UTF-8">
<title>Eliminar Producto</title>
<style type="text/css">
body {
	color: purple;
}

h1 {
	text-align: center;
}

div {
	width: 400px;
	margin: 50px auto;
	padding: 15px;
	background-color: smocke;
	border: 1px solid purple; input { display : block;
	margin-bottom: 15px;
}

input {
	color: purple;
	margin: 0 auto;
	display: block;
	margin-bottom: 15px;
	border: 1px solid purple;
	padding: 7px;
	display: block;
}}
</style>
</head>
<body>
<!--  -->
	<div>
		<h1>Eliminar Producto</h1>
		<form action="doEliminar" method="post">
			<input type="text" name="nombre"
				placeholder="Nombre del producto a eliminar"> <input
				type="submit" value="Eliminar">
		</form>
	</div>

</body>
</html> 