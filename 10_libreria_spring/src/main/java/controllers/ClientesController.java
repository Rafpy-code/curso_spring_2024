package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.Cliente;
import services.implementations.ClientesServiceImpl;
import services.implementations.LibrosServiceImpl;

@Controller
public class ClientesController {
	
	@Autowired
	ClientesServiceImpl clientesServiceImpl;
	@Autowired
	LibrosServiceImpl librosServiceImpl;
	
	@PostMapping(value="alta")
	public String altaCliente(@ModelAttribute Cliente cliente, Model model) {
		if(!clientesServiceImpl.altaCliente(cliente)) {
			model.addAttribute("mensajeAlta","El cliente ya existe, no se añadió!!!");
			return "nuevo";
		}		
		return "login";
	}
	
	@GetMapping(value="login")
	public String login (@RequestParam("usuario") String usuario,@RequestParam("password") String password, Model model) {
		if(clientesServiceImpl.autenticarCliente(usuario, password) != null) {
			model.addAttribute("mensaje", "El usaurio no existe!");
			return "login";
		}
		model.addAttribute("temas", librosServiceImpl.getTemas());	
		return "visor";
	}

}
