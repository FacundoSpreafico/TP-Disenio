package gestores;

import DAO.PorcentajeHijoDAO;
import DAO.PorcentajeHijoDAOImp;
import entidades.HistorialPorcentajeHijo;

public class GestorPorcentajeHijo {
	
	private static GestorPorcentajeHijo _INSTANCE;
	private PorcentajeHijoDAO porcentajeHijoDAO = new PorcentajeHijoDAOImp();
	
	public static GestorPorcentajeHijo getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorPorcentajeHijo();
		}
		return _INSTANCE;
	}
	
	public HistorialPorcentajeHijo getHistorialActual(int cantHijos) {
		String cantidad;
		switch (cantHijos) {
		case 0: cantidad = "Ninguno";
		break;
		case 1: cantidad = "Uno";
		break;
		case 2: cantidad = "Dos o mas";
		break;
		default: cantidad = "Dos o mas";
		}
		return porcentajeHijoDAO.getPorcentajeActual(cantidad);
		
	}
}
