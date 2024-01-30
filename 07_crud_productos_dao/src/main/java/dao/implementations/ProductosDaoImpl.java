package dao.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.interfaces.ProductosDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import models.Producto;

@Repository
public class ProductosDaoImpl implements ProductosDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	@Override
	public void save(Producto producto) {
		em.persist(producto);
	}

	
	@Override
	public Producto findByNombre(String nombre) {
		String jpql = "select p from Producto p where p.nombre = ?1";
		TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
		query.setParameter(1, nombre);
		if (query.getResultList().size() > 0) {
			return query.getResultList().get(0);
		}
		return null;
	}

	@Override
	public List<Producto> findByCategoria(String categoria) {
		String jpql = "select p from Producto p where p.categoria = ?1";
		TypedQuery<Producto> query = em.createQuery(jpql, Producto.class);
		query.setParameter(1, categoria);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void update(Producto producto) {
		//em.refresh(producto); //Reintegra el producto al productoServiceImpl
		em.merge(producto);

	}

	@Transactional
	@Override
	public void delete(Producto producto) {
		//em.remove(em.find(Producto.class, producto.getIdProducto()));
		//em.refresh(producto); //Reintegra el producto al productoServiceImpl
		em.remove(producto);

	}


	@Override
	public void deleteByNombre(String nombre) {
		
		  String jpql ="delete from Producto p where p.nombre=?1"; 
		  TypedQuery<Producto> query= em.createQuery(jpql, Producto.class); 
		  query.setParameter(1, nombre);
		  query.executeUpdate();	 
	}

}
