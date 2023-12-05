package gestores;

import DAO.DescuentoDAO;
import DAO.DescuentoDAOImp;
import entidades.HistorialDescuentoPorUnidadAdicional;

public class GestorDescuentoPorUnidAdicional {
	private static GestorDescuentoPorUnidAdicional _INSTANCE;	
	private DescuentoDAO descuentoDAO = new DescuentoDAOImp();

	 public static GestorDescuentoPorUnidAdicional getInstance() {
			if (_INSTANCE == null) {
				_INSTANCE = new GestorDescuentoPorUnidAdicional();
			}
			return _INSTANCE;
	 }
	 
	public HistorialDescuentoPorUnidadAdicional getHistorialActual(String cantUnidades) {
		return descuentoDAO.getPorcentajeActual(cantUnidades);
	}
}
