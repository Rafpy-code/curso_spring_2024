package dao.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import models.Producto;

public interface ProductosDao extends JpaRepository<Producto, Integer> {
	//Solo se declaran los métodos personalizados
	Producto findByNombre(String nombre);
	List<Producto> findByCategoria(String categoria);
	
	@Transactional
	@Modifying
	void deleteByNombre(String nombre);
}
