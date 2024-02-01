package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import models.Cliente;
import models.Libro;
import models.Tema;
import services.implementations.LibrosServiceImpl;
import services.interfaces.ClientesServiceInterface;
import services.interfaces.LibrosServiceInterface;

@Controller
public class LibrosController {

	@Autowired
	ClientesServiceInterface clientesServiceInterface;
	@Autowired
	LibrosServiceInterface librosServiceInterface;
	
	
	@PostMapping(value="alta")
	public String altaCliente(@ModelAttribute Cliente cliente, Model model) {
		if(!clientesServiceInterface.altaCliente(cliente)) {
			model.addAttribute("mensajeAlta","El cliente ya existe, no se añadió!!!");
			return "nuevo";
		}		
		return "login";
	}
	
	@GetMapping(value="login")
	public String login (@RequestParam("usuario") String usuario,@RequestParam("password") String password, Model model) {
		if(clientesServiceInterface.autenticarCliente(usuario, password) != null) {
			model.addAttribute("mensaje", "El usaurio no existe!");
			return "login";
		}
		model.addAttribute("temas", librosServiceInterface.getTemas());	
		return "visor";
	}


	@GetMapping(value = "libros", produces = "aplication/json")
	public @ResponseBody List<Libro> librosPorTema(@RequestParam("idTema") int idTema) {
		return librosServiceInterface.getLibrosPorIdTema(idTema);
	}

	@GetMapping(value = "agregarCarrito", produces = "aplication/json")
	public @ResponseBody Libro getLibro(@RequestParam("isbn") int isbn, HttpSession sesion) {
		List<Libro> carrito = new ArrayList<Libro>();
		Libro libro = librosServiceInterface.getLibroPorIsbn(isbn);

		if (sesion.getAttribute("carrito") != null) {
			carrito = (List<Libro>) sesion.getAttribute("carrito");
		}

		carrito.add(libro);
		sesion.setAttribute("carrito", carrito);

		return libro;

	}

	@GetMapping(value = "quitarCarrito", produces = "aplication/json")
	public @ResponseBody Tema getTema(@RequestParam("posicion") int posicion, HttpSession sesion) {
		return librosServiceInterface.getTema(posicion);
	}

}
