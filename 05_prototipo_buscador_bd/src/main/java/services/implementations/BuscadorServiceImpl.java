package services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import models.Resultado;
import services.interfaces.BuscadorService;

@Service
public class BuscadorServiceImpl implements BuscadorService {

	@PersistenceContext // Para inyectar el EntityManager
	EntityManager em;
	
	@Transactional // Para que spring inicie y confirme la transacción automáticamente
	@Override
	public void agregar(Resultado resultado) {		
		em.persist(resultado);		
	}
	
	// Al select no se le pone la anotación @Transactional
	@Override
	public List<Resultado> buscar(String tematica) {
		String jpql = "select r from Resutado r where r.tematica = ?1";
		TypedQuery<Resultado> query= em.createQuery(jpql, Resultado.class);
		query.setParameter(1, tematica);
		return query.getResultList();		
	}

	

}
