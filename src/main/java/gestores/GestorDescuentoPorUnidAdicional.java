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

	public HistorialDescuentoPorUnidadAdicional getHistorialActual(Long cantidadVehiculos) {
		String cantidad;
		if (cantidadVehiculos == 0) {
		    cantidad = "Ninguno";
		} else if (cantidadVehiculos == 1) {
		    cantidad = "Uno";
		} else {
		    cantidad = "Dos o mas";
		}
		return descuentoDAO.getPorcentajeActual(cantidad);
	}
	 
/*	public HistorialDescuentoPorUnidadAdicional getHistorialActual(int cantidadVehiculos) {
		return descuentoDAO.getPorcentajeActual(cantidadVehiculos);
	}
	*/
}
