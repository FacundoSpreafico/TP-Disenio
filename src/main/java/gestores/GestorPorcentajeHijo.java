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
		return porcentajeHijoDAO.getPorcentajeActual(cantHijos);
	}
}
