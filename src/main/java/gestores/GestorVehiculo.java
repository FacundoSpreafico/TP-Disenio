package gestores;

import java.util.List;

import DAO.MarcaDAO;
import DAO.MarcaDAOImp;
import DAO.VehiculoDAO;
import DAO.VehiculoDAOImp;
import DTO.MarcaDTO;
import DTO.VehiculoDTO;
import DAO.ModeloDAO;
import DAO.ModeloDAOImp;
import entidades.Marca;
import entidades.Modelo;

public class GestorVehiculo {

	private static GestorVehiculo _INSTANCE;	
	private VehiculoDAO vehiculoDAO = new VehiculoDAOImp();
	private MarcaDAO marcaDAO = new MarcaDAOImp();
	private ModeloDAO modeloDAO = new ModeloDAOImp();
	
	
	public static GestorVehiculo getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorVehiculo();
		}
		return _INSTANCE;
	}

	public void create(VehiculoDTO vehiculo) {
	}
	
	public List<Marca> recuperarMarcas() {
		return marcaDAO.recuperarMarcas();
	}
	public List<Modelo> recuperarModelosPorMarca() {
		return modeloDAO.recuperarModelosPorMarca();
	}
	
	
}
