package gestores;

import DAO.PorcentajePorKmsDAO;
import DAO.PorcentajePorKmsDAOImp;
import entidades.HistorialPorcentajeKM;

public class GestorPorcentajeKms {
	
	private static GestorPorcentajeKms _INSTANCE;
	private PorcentajePorKmsDAO porcentajeKmsDAO= new PorcentajePorKmsDAOImp();
	
	public static GestorPorcentajeKms getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorPorcentajeKms();
		}
		return _INSTANCE;
	}
	
	public HistorialPorcentajeKM getHistorialActual(String cantKmsPorAnio) {
		return porcentajeKmsDAO.getPorcentajeActual(cantKmsPorAnio);
	}
	
	
}
