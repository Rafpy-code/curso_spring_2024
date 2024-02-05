package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Venta;

public interface VentasDao extends JpaRepository<Venta, Integer> {

	// heredados:
	// findAll()

	List<Venta> findByClienteIdCliente(int idCliente);

	List<Venta> findByFechaBetween(Date f1, Date f2);

	// La siguiente query, no hace falta, se pone por claridad
	@Query("select v from Venta v where v.libro.isbn=?1")
	List<Venta> findByLibroIsbn(int isbn);

}
