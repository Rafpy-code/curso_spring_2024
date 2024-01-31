package services.interfaces;

import models.Cliente;

public interface ClientesServiceInterface {
	
	boolean altaCliente(Cliente cliente);	
	Cliente autenticarCliente(String usuario, String password);
	
}
