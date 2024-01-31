package services.interfaces;

import java.util.List;

import models.Tema;

public interface TemasServiceInterface {
	
	Tema getTema(int idTema);
	List<Tema> getTemas();
	
}
