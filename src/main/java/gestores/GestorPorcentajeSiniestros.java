package gestores;

import DAO.PorcentajeSiniestrosDAO;
import DAO.PorcentajeSiniestrosDAOImp;
import entidades.HistorialPorcentajeSiniestros;

public class GestorPorcentajeSiniestros {
	private static GestorPorcentajeSiniestros _INSTANCE;
	private PorcentajeSiniestrosDAO porcentajeSiniestrosDAO = new PorcentajeSiniestrosDAOImp();
	
	public static GestorPorcentajeSiniestros getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorPorcentajeSiniestros();
		}
		return _INSTANCE;
	}
	
	public HistorialPorcentajeSiniestros getHistorialActual(String cantSiniestros) {
		return porcentajeSiniestrosDAO.getPorcentajeActual(cantSiniestros);
	}
	
}
