package mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dtos.ClienteDto;
import dtos.LibroDto;
import dtos.TemaDto;
import model.Cliente;
import model.Libro;
import model.Tema;
import service.implementations.LibrosServiceImpl;
import service.interfaces.LibrosService;

@Component
public class Mapeador {
	
	@Autowired
	LibrosService service;
	public TemaDto temaEntityToDto(Tema tema) {
		return new TemaDto(tema.getIdTema(), tema.getTema());
	}

	public LibroDto libroEntityToDto(Libro libro) {
		return new LibroDto(
				libro.getIsbn(), 
				libro.getTitulo(), 
				libro.getAutor(),
				libro.getPrecio(),
				libro.getPaginas(), 
				service.getTema(libro.getIdTema()));
	}

	public ClienteDto clienteEntityToDto(Cliente cliente) {
		return new ClienteDto(
				cliente.getUsuario(),
				cliente.getPassword(),
				cliente.getEmail(),
				cliente.getTelefono()
				);
	}
	
	public Cliente clienteDtoToEntity(ClienteDto clienteDto) {
		return new Cliente(
				0,
				clienteDto.getUsuario(),
				clienteDto.getPassword(),
				clienteDto.getEmail(),
				clienteDto.getTelefono()
				);
	}
	
}
