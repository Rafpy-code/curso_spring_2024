package dao.interfaces;

import java.util.List;

import models.Producto;

public interface ProductosDao {
	void save(Producto producto);
	Producto findByNombre(String nombre);
	List<Producto> findByCategoria(String categoria);
	void update(Producto producto);
	//void updatePrecioByNombe(String nombre);
	void delete(Producto producto);
	void deleteByNombre(String nombre);
}
