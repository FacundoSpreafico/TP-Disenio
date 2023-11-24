package gestores;

import java.util.List;

import DAO.LocalidadDAO;
import DAO.LocalidadDAOImp;
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
	
	public void obtenerPaises(){
		List<Pais> paises = localidadDAO.obtenerPaises();
	}
}
