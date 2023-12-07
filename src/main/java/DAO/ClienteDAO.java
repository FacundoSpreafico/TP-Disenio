package DAO;

import java.util.List;

import DTO.ClienteDTO;
import entidades.Cliente;
import entidades.Poliza; 

public interface ClienteDAO {

	public void create(Cliente cliente);
	public List<Cliente> buscarClientes(ClienteDTO cliente);
	public int recuperarID(String nroCliente);
    public Long obtenerCantidadVehiculos(int idCliente);
	public void actualizarEstadoCliente(Cliente cliente, Poliza poliza);
	public List<Poliza> devolverPolizasVigentes(Cliente cliente);
	public Long obtenerCantidadCuotasImpagas(Cliente cliente);
	public Long obtenerCantidadPolizasAsociadas(Cliente cliente);
	
}
