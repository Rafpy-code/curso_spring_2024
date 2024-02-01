package service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dtos.ClienteDto;
import mappers.Mapeador;
import service.interfaces.ClientesService;
@Service
public class ClientesServiceImpl implements ClientesService {
	
	@Autowired
	ClientesDao clientesDao;
	@Autowired
	Mapeador mapeador;

	@Override
	public ClienteDto autenticarCliente(String usuario, String password) {
		return mapeador.clienteEntityToDto(clientesDao.findByUsuarioAndPassword(usuario, password));
	}

	@Override
	public boolean altaCliente(ClienteDto cliente) {
		if(clientesDao.findByUsuario(cliente.getUsuario())==null) {
			clientesDao.save(mapeador.clienteDtoToEntity(cliente));
			return true;
		}
		return false;
	}

}
