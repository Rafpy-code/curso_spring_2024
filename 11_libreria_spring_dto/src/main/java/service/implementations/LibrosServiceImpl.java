package service.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.LibrosDao;
import dao.TemasDao;
import dtos.LibroDto;
import dtos.TemaDto;
import mappers.Mapeador;
import model.Libro;
import service.interfaces.LibrosService;

@Service
public class LibrosServiceImpl implements LibrosService {
	@Autowired
	TemasDao temasDao;
	@Autowired
	LibrosDao librosDao;
	@Autowired
	Mapeador mapeador;

	@Override
	public List<TemaDto> getTemas() {
		return temasDao.findAll().stream().map(t -> mapeador.temaEntityToDto(t)).toList();
	}

	@Override
	public List<LibroDto> librosTema(int idTema) {
		if (idTema == 0) {
			return librosDao.findAll().stream().map(l -> mapeador.libroEntityToDto(l)).toList();
		}
		return librosDao.findByIdTema(idTema).stream().map(l -> mapeador.libroEntityToDto(l)).toList();
	}

	@Override
	public LibroDto getLibro(int isbn) {
		Optional<Libro> resultado = librosDao.findById(isbn);
		// return resultado.isPresent()?resultado.get():null;
		return resultado
				.map(l -> mapeador.libroEntityToDto(l))
				.orElse(null);
	}

	@Override
	public TemaDto getTema(int idTema) {
		return temasDao.findById(idTema)
				.map(t -> mapeador.temaEntityToDto(t))
				.orElse(null);
	}

}
