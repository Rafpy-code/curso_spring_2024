package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Tema;

public interface TemasDaoInterface  extends JpaRepository<Tema, Integer>  {
	
}
