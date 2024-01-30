package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import models.Producto;
import services.implementations.ProductosServicesImpl;
import services.interfaces.ProductosService;

@Controller
public class ProductosController {
	@Autowired
	ProductosService productosService;

	@PostMapping(value = "alta")
	public String alta(@ModelAttribute Producto producto, Model model) {
		if(!productosService.alta(producto)) {
			model.addAttribute("mensajeAlta","Producto "+producto.getNombre()+" repetido, no se añadió!!!");
		}		
		return "menu";
	}

	@GetMapping(value = "buscar", produces = "application/json") 
	public @ResponseBody List<Producto> buscar(@RequestParam("categoria") String categoria) {
		return productosService.buscarProductoPorCategoria(categoria);
	}

	@PostMapping(value = "modificar") 
	public String modificar(@RequestParam("nombre") String nombre, @RequestParam("nuevoPrecio") String nuevoPrecio,
			Model model) {
		Double np = Double.parseDouble(nuevoPrecio);
		productosService.mofificarPrecioProducto(nombre, np);
		return "menu"; // Nombre de la página a la que debe dirigirnos el FrontController
	}

	@GetMapping(value = "eliminar")
	public String eliminar(@RequestParam("nombre") String nombre, Model model) {
		Producto producto = productosService.eliminarProducto(nombre);
		if(producto!=null) {
			model.addAttribute("mensajeEliminar","se ha eliminado el producto "+nombre+" de la categoría "+producto.getCategoria());
		}else {
			model.addAttribute("mensajeEliminar","el producto "+nombre+ " no existe!!!");
		}
		return "menu";
	}
}
