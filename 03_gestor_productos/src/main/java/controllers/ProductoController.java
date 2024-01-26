package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.Producto;
import services.interfaces.ProductoService;

@Controller
public class ProductoController {
	@Autowired
	ProductoService productoService;

	@GetMapping(value = "buscarPorCategoria") // o @PostMapping según se requiera
	public String buscar(@RequestParam("categoria") String categoria, Model model) {
		List<Producto> productos = productoService.mostrarCategoriaFuncional(categoria);
		model.addAttribute("productos", productos); // Equivale al request.setAttribute(...)
		return "productos"; // Nombre de la página a la que debe dirigirnos el FrontController
	}

	@PostMapping(value = "doAlta")
	public String alta(@ModelAttribute Producto producto) {
		productoService.agregarProducto(producto);
		return "inicio";
	}
	
	@PostMapping(value = "doEliminar")
	public String eliminar(@ModelAttribute String nombre) {
		productoService.eliminarProductoFuncional(nombre);
		return "inicio"
;	}
}
