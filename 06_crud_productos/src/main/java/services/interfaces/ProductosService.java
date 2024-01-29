package services.interfaces;

import java.util.List;

import models.Producto;

public interface ProductosService {
	// CRUD
	boolean alta(Producto producto);
	List<Producto> buscarProductoPorCategoria(String categoria);
	void mofificarPrecioProducto(String nombre, double nuevoPrecio);
	Producto eliminarProducto(String nombre);
	

	List<Producto> getProductos();
}
