package services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.interfaces.ProductosDao;
import jakarta.persistence.TypedQuery;
import models.Producto;
import services.interfaces.ProductosService;

//Le dice a spring que cree insatancias de esta clase
@Service
public class ProductosServicesImpl implements ProductosService {

	// Pedir la inyección de productos dao
	@Autowired
	ProductosDao productosDao;

	@Transactional
	@Override
	public boolean alta(Producto producto) {
		String nombre = producto.getNombre();
		if (productosDao.findByNombre(nombre) == null) {
			productosDao.save(producto);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Producto> buscarProductoPorCategoria(String categoria) {
		return productosDao.findByCategoria(categoria);
	}

	@Transactional
	@Override
	public void mofificarPrecioProducto(String nombre, double nuevoPrecio) {
		Producto producto = productosDao.findByNombre(nombre);
		if (producto != null) {
			productosDao.save(producto);
		}
	}

	@Transactional
	@Override
	public Producto eliminarProducto(String nombre) {
		Producto p = productosDao.findByNombre(nombre);
		if (p != null) {
			productosDao.deleteByNombre(nombre);
			return p;
		}
		return null;
	}

	@Override
	public List<Producto> todos() {
		return productosDao.findAll();
	}

}
