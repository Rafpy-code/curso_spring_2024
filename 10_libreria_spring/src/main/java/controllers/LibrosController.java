package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import models.Libro;
import models.Tema;
import services.implementations.LibrosServiceImpl;

@Controller
public class LibrosController {

	@Autowired
	LibrosServiceImpl librosServiceImpl;

	@GetMapping(value = "libros", produces = "aplication/json")
	public @ResponseBody List<Libro> librosPorTema(@RequestParam("idTema") int idTema) {
		return librosServiceImpl.getLibrosPorIdTema(idTema);
	}

	@GetMapping(value = "agregarCarrito", produces = "aplication/json")
	public @ResponseBody Libro getLibro(@RequestParam("isbn") int isbn, HttpSession sesion) {
		List<Libro> carrito = new ArrayList<Libro>();
		Libro libro = librosServiceImpl.getLibroPorIsbn(isbn);

		if (sesion.getAttribute("carrito") != null) {
			carrito = (List<Libro>) sesion.getAttribute("carrito");
		}

		carrito.add(libro);
		sesion.setAttribute("carrito", carrito);

		return libro;

	}

	@GetMapping(value = "quitarCarrito", produces = "aplication/json")
	public @ResponseBody Tema getTema(@RequestParam("posicion") int posicion, HttpSession sesion) {
		return librosServiceImpl.getTema(posicion);
	}

}
