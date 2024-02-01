function gestionarPeticion(url, params) {
	$.get(url, params, function(data) {
		var tabla = "<table border='1'><tr><th>Titulo</th><th>Precio</th><th>Páginas</th><th>Tema</th><th></th></tr>";
		$.each(data, function(i, p) {
			tabla += "<tr><td>" + p.titulo + "</td><td>" + p.precio + "</td><td>" + p.paginas + "</td><td>" + p.temaDto.tema + "</td><td><a href='#' onclick='agregarCarrito(" + p.isbn + ")'>Agregar</a></td></tr>";
		});
		tabla += "</table>";
		$("#tbLibros").html(tabla);
	});
}
function agregarCarrito(isbn) {
	var url = "agregarCarrito";
	var params = { "isbn": isbn };
	pintarCarrito(params, url);
}

function quitarCarrito(pos) {
	var url = "quitarCarrito";
	var params = { "pos": pos };
	pintarCarrito(params, url);
}
function pintarCarrito(params, url) {
	$.get(url, params, function(data) {
		var tabla = "<table border='1'><tr><th>Titulo</th><th>Precio</th><th>Páginas</th><th>Tema</th><th></th></tr>";
		$.each(data, function(i, p) {
			tabla += "<tr><td>" + p.titulo + "</td><td>" + p.precio + "</td><td>" + p.paginas + "</td><td>" + p.temaDto.tema + "</td><td><a href='#' onclick='quitarCarrito(" + i + ")'>Quitar</a></td></tr>";
		});
		tabla += "</table>";
		$("#tbCarrito").html(tabla);
	});
}


$(document).ready(function() {
	$("#temaSel").change(function() {
		var url = "libros";
		var params = { "idTema": $("#temaSel").val() };
		gestionarPeticion(url, params);
	});
});