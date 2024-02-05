package service.implementations;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dao.LibrosDao;
import dao.VentasDao;
import dtos.LibroDto;
import dtos.VentaDto;
import mappers.Mapeador;
import model.Cliente;
import model.Venta;
import service.interfaces.VentasService;

@Service
public class VentasServiceImpl implements VentasService {

	@Autowired
	VentasDao ventasDao;
	@Autowired
	ClientesDao clientesDao;
	@Autowired
	LibrosDao librosDao;
	@Autowired
	Mapeador mapeador;
	
	@Override
	public List<VentaDto> informeVentasCliente(String usuario) {
		
		return ventasDao.findByClienteIdCliente(clientesDao.findByUsuario(usuario).getIdCliente())
				.stream()
				.map(v -> mapeador.ventaEntityToDto(v))
				.toList();
	}

	@Override
	public void registrarCompra(String usuario, List<LibroDto> libros) {
		Cliente cliente = clientesDao.findByUsuario(usuario);
		for(LibroDto dto: libros) {
			Venta venta = new Venta(0, cliente, mapeador.libroDtoToEntity(dto), new Date());
			ventasDao.save(venta);
		}
	}

}
