package gestores;

import java.util.Random;

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
	
	public Double getDescuento (Double monto) {
		Random random = new Random();
        String cantidad = String.valueOf(random.nextInt(4));
		Long cantidadV  = Long.parseLong(cantidad);
        Double valorPorcentual = this.getHistorialActual(cantidadV).getValorPorcentual();
        return (monto * valorPorcentual)/100;
	}
	
	 
/*	public HistorialDescuentoPorUnidadAdicional getHistorialActual(int cantidadVehiculos) {
		return descuentoDAO.getPorcentajeActual(cantidadVehiculos);
	}
	*/
}
