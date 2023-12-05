package gestores;

import DAO.DerechoEmisionDAO;
import DAO.DerechoEmisionDAOImp;
import entidades.HistorialDerechoEmision;

public class GestorDerechoEmision {
	
	private static GestorDerechoEmision _INSTANCE;
	private DerechoEmisionDAO derechoEmisionDAO = new DerechoEmisionDAOImp();
	
	public static GestorDerechoEmision getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorDerechoEmision();
		}
		return _INSTANCE;
	}
	
	public HistorialDerechoEmision getHistorialActual() {
		return derechoEmisionDAO.getHistorialActual();
	}
	
}
