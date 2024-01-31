package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Libro;

public interface LibrosDaoInterface extends JpaRepository<Libro, Integer>  {
	
	Libro findByTitulo(String titulo);
	List<Libro> findByAutor(String autor);
	List<Libro> findByIdTema(int idTema);
	// heredados
	// findAll
	// findById(int isbn)
}
