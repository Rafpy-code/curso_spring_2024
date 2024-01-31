package services.interfaces;

import java.util.List;

import models.Libro;
import models.Tema;


public interface LibrosServiceInterface {
	
	List<Tema> getTemas();
	List<Libro> getLibrosPorIdTema(int id);
	Libro getLibroPorIsbn(int isbn);
	Tema getTema(int idTema);

}