package gestores;

import java.util.List;

import DAO.ClienteDAO;
import DTO.ClienteDTO;
import entidades.Cliente;

public class GestorCliente{

	private static GestorCliente _INSTANCE;
	private ClienteDAO clienteDAO;
	
	public static GestorCliente getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorCliente();
		}
		return _INSTANCE;
	}
	
	public List<ClienteDTO> buscar(ClienteDTO cliente) {
		List<Cliente> clientesEncontrados = clienteDAO.buscarClientes(cliente);
		return null;
	}
	
}
