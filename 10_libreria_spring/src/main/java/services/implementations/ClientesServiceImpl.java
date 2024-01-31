package services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ClientesDaoInterface;
import models.Cliente;
import services.interfaces.ClientesServiceInterface;

@Service
public class ClientesServiceImpl implements ClientesServiceInterface {

	@Autowired
	ClientesDaoInterface clientesDaoInterface;
	
	@Transactional
	@Override
	public boolean altaCliente(Cliente cliente) {
		if(clientesDaoInterface.findByUsuario(cliente.getUsuario()) == null) {
			clientesDaoInterface.save(cliente);
			return true;
		}
		return false;
	}

	@Override
	public Cliente autenticarCliente(String usuario, String password) {
		Cliente cliente = clientesDaoInterface.findByUsuarioAndPassword(usuario, password);
		return cliente;
	}

}
