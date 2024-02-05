package dao;

import org.springframework.data.jpa.repository.Query;

import model.Venta;

public interface VentasDao {

	//heredados:
		//findAll()
		
		// Tema asociado a un determinado libro
		@Query("select c from Cliente c join v.ventas v where v.idCliente = ?1")
		Venta findByIdCliente(Integer idCliente);
		
}
