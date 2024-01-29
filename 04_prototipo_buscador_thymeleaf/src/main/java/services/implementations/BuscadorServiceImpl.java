package services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import models.Resultado;
import services.interfaces.BuscadorService;

@Service
public class BuscadorServiceImpl implements BuscadorService {
	static List<Resultado> resultados = new ArrayList<>(
			List.of(new Resultado("http://www.fnac.es", "libros", "Libros y más"),
					new Resultado("http://www.mybook.com", "libros", "librería de temas varios"),
					new Resultado("http://www.game.es", "juegos", "Juegos variados"),
					new Resultado("http://www.music.es", "música", "La mejor música"),
					new Resultado("http://www.tech.com", "libros", "Libros técnicos"),
					new Resultado("http://www.eljuego.es", "juegos", "Juegos on-line")));

	@Override
	public List<Resultado> buscar(String tematica) {
		return resultados.stream().filter(r -> r.getTematica().equals(tematica)).toList();
	}

	@Override
	public void agregar(Resultado resultado) {
		resultados.add(resultado);

	}

}