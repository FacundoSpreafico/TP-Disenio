package gestores;

import java.util.List;

import DAO.MarcaDAO;
import DAO.MarcaDAOImp;
import DAO.ModeloDAO;
import DAO.ModeloDAOImp;
import DAO.VehiculoDAO;
import DAO.VehiculoDAOImp;
import DTO.VehiculoDTO;
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
	
	public Marca recuperarMarcaPorNombre(String nombre) {
		return marcaDAO.recuperarMarcaPorNombre(nombre);
	}
	
	
	public List<Modelo> recuperarModelosPorMarca(Marca marca) {
		return modeloDAO.recuperarModelosPorMarca(marca);
	}

	public Modelo recuperarModeloPorNombre(String nombre) {
		return modeloDAO.recuperarModeloPorNombre(nombre);
	}
	
	//Implementar funcion
	public boolean validarDatosVehiculo(VehiculoDTO vehiculoDTO) {
		return false;
	}
	
}
