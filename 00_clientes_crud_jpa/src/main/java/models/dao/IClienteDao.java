package models.dao;

import org.springframework.data.repository.CrudRepository;

import models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{


}
