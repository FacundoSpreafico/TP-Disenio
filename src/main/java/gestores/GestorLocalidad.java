package gestores;

import java.util.List;

import DAO.LocalidadDAO;
import DAO.LocalidadDAOImp;
import DTO.DomicilioRiesgoDTO;
import entidades.Localidad;
import entidades.Pais;
import entidades.Provincia;

public class GestorLocalidad {
	private static GestorLocalidad _INSTANCE;
	private LocalidadDAO localidadDAO;
	
	private GestorLocalidad() {
		localidadDAO = new LocalidadDAOImp();
	}
	
	public static GestorLocalidad getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorLocalidad();
		}
		return _INSTANCE;
	}
	
	public List<Pais> obtenerPaises(){
		return localidadDAO.obtenerPaises();
	}
	
	public Pais recuperarPaisPorNombre(String nombre) {
		return localidadDAO.recuperarPaisPorNombre(nombre);
	}
	
	public Provincia recuperarProvinciaPorNombre(String nombre) {
		return localidadDAO.recuperarProvinciaPorNombre(nombre);
	}
	
	public List<Provincia> obtenerProvincias(Pais pais){
		return localidadDAO.obtenerProvincias(pais);
	}
	
	public List<Localidad> obtenerLocalidades(Provincia provincia){
		return localidadDAO.obtenerLocalidades(provincia);
	}
	
	public Localidad obtenerDomicilioDeRiesgo(DomicilioRiesgoDTO domicilio) {
		return localidadDAO.obtenerLocalidad(domicilio.getLocalidad(), domicilio.getProvincia(), domicilio.getPais());
	}
	
	
	
	
}
