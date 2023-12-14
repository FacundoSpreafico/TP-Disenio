package gestores;

import java.util.ArrayList;
import java.util.List;

import DAO.ClienteDAO;
import DAO.ClienteDAOImp;
import DTO.ClienteDTO;
import DTO.DomicilioDTO;
import entidades.Cliente;

public class GestorCliente{

	private static GestorCliente _INSTANCE;
	private ClienteDAO clienteDAO = new ClienteDAOImp();
	
	public static GestorCliente getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorCliente();
		}
		return _INSTANCE;
	}
	
	public void create(Cliente cliente) {
	clienteDAO.create(cliente);
	}
	
	public int recuperarID(String nroCliente) {
		return clienteDAO.recuperarID(nroCliente);
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
	
	public List<ClienteDTO> buscar() {
		 List<ClienteDTO> resultado = new ArrayList<>();
		 List<Cliente> clientes = clienteDAO.buscarClientes();
		 
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
        DomicilioDTO domicilio = new DomicilioDTO();
        domicilio.setCalle(clienteEntidad.getDomicilio().getCalle());
        domicilio.setAltura(clienteEntidad.getDomicilio().getAltura());
        clienteDTO.setDomicilio(domicilio);
	    return clienteDTO;
	}
	
	public Cliente obtenerPorId(ClienteDTO cliente) {
		return clienteDAO.obtenerPorId(cliente.getIdCliente());	
	}

	public Long obtenerCantidadVehiculos(int idCliente) {
		return clienteDAO.obtenerCantidadVehiculos(idCliente);
		
	}
	
}
