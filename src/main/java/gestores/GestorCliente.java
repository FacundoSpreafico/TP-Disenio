package gestores;

import java.util.ArrayList;
import java.util.List;

import DAO.ClienteDAO;
import DAO.ClienteDAOImp;
import DTO.ClienteDTO;
import entidades.Cliente;

public class GestorCliente{

	private static GestorCliente _INSTANCE;
	private ClienteDAOImp clienteDAO = new ClienteDAOImp();
	
	public static GestorCliente getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorCliente();
		}
		return _INSTANCE;
	}
	
	public List<ClienteDTO> buscar(ClienteDTO cliente) {
		 List<ClienteDTO> resultado = new ArrayList<>();
		 List<Cliente> clientes = clienteDAO.buscarClientes(cliente);

		 for (Cliente clienteEntidad : clientes) {
		     ClienteDTO clienteDTO = convertirEntidadADTO(clienteEntidad);
		     resultado.add(clienteDTO);
		  }
		 return resultado;
	}
	
	private ClienteDTO convertirEntidadADTO(Cliente clienteEntidad) {
	    ClienteDTO clienteDTO = new ClienteDTO();
	    clienteDTO.setNombre(clienteEntidad.getNombre());
	    clienteDTO.setApellido(clienteEntidad.getApellido());
	    clienteDTO.setNroCliente(clienteEntidad.getNroCliente());
        clienteDTO.setNroDocumento(clienteEntidad.getNroDocumento());
        clienteDTO.setTipoDocumento(clienteEntidad.getTipoDocumento());
	    return clienteDTO;
	}
	
}
