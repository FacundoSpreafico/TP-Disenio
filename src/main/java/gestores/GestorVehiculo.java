package gestores;

import java.util.List;

import DAO.MarcaDAO;
import DAO.MarcaDAOImp;
import DAO.ModeloDAO;
import DAO.ModeloDAOImp;
import DTO.VehiculoDTO;
import entidades.Localidad;
import entidades.Marca;
import entidades.Modelo;
import entidades.Vehiculo;

public class GestorVehiculo {

	private static GestorVehiculo _INSTANCE;	
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
	
	public Vehiculo crearVehiculo (VehiculoDTO vehiculoDTO) {
		Vehiculo vehiculo = new Vehiculo();
	    setearAtributosSimples(vehiculo,vehiculoDTO);
		Modelo modelo = modeloDAO.obtenerModelo(vehiculoDTO.getNombreMarca(), vehiculoDTO.getNombreModelo());
		vehiculo.setModelo(modelo);
		Localidad localidad = GestorLocalidad.getInstance().obtenerDomicilioDeRiesgo(vehiculoDTO.getDomicilio());
		vehiculo.setLocalidad(localidad);
        return vehiculo;
	}
	
	public void setearAtributosSimples(Vehiculo vehiculo, VehiculoDTO vehiculoDTO) {
		vehiculo.setMotor(vehiculoDTO.getMotor());
		vehiculo.setPatente(vehiculoDTO.getPatente());
		vehiculo.setChasis(vehiculoDTO.getChasis());
		vehiculo.setAnioVehiculo(vehiculoDTO.getAnioVehiculo());
	}
	
}
