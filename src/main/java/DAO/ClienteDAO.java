package DAO;

import java.util.List;

import DTO.ClienteDTO;
import entidades.Cliente; 

public interface ClienteDAO {

	public void create(Cliente cliente);
	public List<Cliente> buscarClientes(ClienteDTO cliente);
	
	
}
