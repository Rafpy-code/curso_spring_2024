package services.implementations;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import models.Producto;
import services.interfaces.ProductosService;

@Service
public class ProductosServicesImpl implements ProductosService {

	// Para inyectar el EntityManager
	@PersistenceContext
	EntityManager em;

	private Producto buscarProductoPorNombre(String nombre) {
		String jpql = "select p from Producto p where p.nombre = ?1";
		TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
		query.setParameter(1, nombre);
		if (query.getResultList().size() > 0) {
			return query.getResultList().get(0);
		}
		return null;
	}

	@Transactional
	@Override
	public boolean alta(Producto producto) {
		String nombre = producto.getNombre();
		if (buscarProductoPorNombre(nombre) == null) {
			em.persist(producto);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Producto> buscarProductoPorCategoria(String categoria) {
		String jpql = "select p from Producto p where p.categoria = ?1";
		TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
		query.setParameter(1, categoria);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void mofificarPrecioProducto(String nombre, double nuevoPrecio) {
		/*
		 * String jpql = "update Producto p set p.precio=?1 where p.nombre=?2"; Query
		 * query = em.createQuery(jpql); query.setParameter(1, nuevoPrecio);
		 * query.setParameter(2, nombre); query.executeUpdate();
		 */
		Producto producto = buscarProductoPorNombre(nombre);
		if(producto !=null) {
			em.merge(producto);
		}
	}

	@Transactional
	@Override
	public Producto eliminarProducto(String nombre) {
		Producto p = buscarProductoPorNombre(nombre);
		if (p != null) {
			/*
			 * String jpql ="delete from Producto p where p.nombre=?1"; TypedQuery<Producto>
			 * query= em.createQuery(jpql, Producto.class); query.setParameter(1, nombre);
			 * query.executeUpdate();
			 */
			em.remove(p);
			return p;
		}
		return null;
	}

	@Transactional
	@Override
	public List<Producto> getProductos() {
		String jpql = "select p from Producto p";
		TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
		return query.getResultList();
	}

}
