package service.interfaces;

import java.util.List;

import dtos.LibroDto;
import dtos.VentaDto;

public interface VentasService {
	
	List<VentaDto> informeVentasCliente(String usuario);
	void registrarCompra (String usuario, List<LibroDto> libros); 
	
}
