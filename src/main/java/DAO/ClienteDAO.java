package DAO;

import java.util.List;

import DTO.ClienteDTO;
import entidades.Cliente; 

public interface ClienteDAO {

	public List<Cliente> buscarClientes(ClienteDTO cliente);
}
