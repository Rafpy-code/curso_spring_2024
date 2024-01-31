package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Cliente;


public interface ClientesDaoInterface extends JpaRepository<Cliente, Integer>  {
	Cliente findByUsuarioAndPassword(String usuario, String password);
	Cliente findByUsuario(String usuario);
	// No se ponen porque ya están heredados
	//save(Cliente cliente)
}
