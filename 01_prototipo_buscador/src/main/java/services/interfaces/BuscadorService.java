package services.interfaces;

import java.util.List;

import models.Resultado;

public interface BuscadorService {
	List<Resultado> buscar(String tematica);
	
	void agregar(Resultado resultado);
}
