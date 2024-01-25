package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import models.Resultado;
import services.interfaces.BuscadorService;

@Controller
public class BuscadorController {

	@Autowired
	BuscadorService buscadorService;

	@GetMapping(value = "buscar") // o @PostMapping según se requiera
	public String buscar(@RequestParam("tematica") String tematica, Model model) {
		List<Resultado> resultados = buscadorService.buscar(tematica);
		model.addAttribute("resultados", resultados); // Equivale al request.setAttribute(...)
		return "resultados"; // Nombre de la página a la que debe dirigirnos el FrontController
	}

	@GetMapping(value = { "toBuscar" })
	public String toBuscar() {
		return "buscar";
	}

	@PostMapping(value = "alta")
	public String alta(@ModelAttribute Resultado resultado) {
		buscadorService.agregar(resultado);
		return "menu";
	}

	@GetMapping(value = "toAlta")
	public String toAlta() {
		return "alta";
	}

	@GetMapping(value = "/")
	public String bienvenida() {
		return "menu";
	}

}
