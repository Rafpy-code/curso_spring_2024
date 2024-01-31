package services.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDaoInterface;
import dao.TemasDaoInterface;
import models.Libro;
import models.Tema;
import services.interfaces.LibrosServiceInterface;

@Service
public class LibrosServiceImpl implements LibrosServiceInterface {
	
	@Autowired
	LibrosDaoInterface librosDaoInterface;
	@Autowired
	TemasDaoInterface temasDaoInterface;
	
	@Override
	public List<Tema> getTemas() {
		List<Tema> temas = temasDaoInterface.findAll();
		return temas;
	}

	@Override
	public List<Libro> getLibrosPorIdTema(int idTema) {
		if(idTema == 0) {
			return librosDaoInterface.findAll();
		}
		return librosDaoInterface.findByIdTema(idTema);
	}

	@Override
	public Libro getLibroPorIsbn(int isbn) {
		Optional<Libro> resultado = librosDaoInterface.findById(isbn);
		// return resultado.isPresent()?resultado.get():null;
		return resultado.orElse(null);
	}

	@Override
	public Tema getTema(int idTema) {
		return temasDaoInterface.findById(idTema).orElse(null);
	}

}
