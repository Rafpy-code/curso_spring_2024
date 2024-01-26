package services.interfaces;

import java.util.List;

import models.Producto;

public interface ProductoService {

	void agregarProducto(Producto producto);

	List<Producto> mostrarCategoria(String categoria);

	List<Producto> mostrarCategoriaFuncional(String categoria);

	void eliminarProducto(String nombre);

	void eliminarProductoFuncional(String nombre);

}