package gestores;

import DAO.SumaAseguradaDAO;
import DAO.SumaAseguradaDAOImp;
import DTO.ModeloDTO;

public class GestorSumaAsegurada {
	
	private SumaAseguradaDAO sumaAseguradaDAO = new SumaAseguradaDAOImp();
	
	private static GestorSumaAsegurada _INSTANCE;	

	public static GestorSumaAsegurada getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorSumaAsegurada();
		}
		return _INSTANCE;
	}
	
	public double devolverSumaAsegurada (ModeloDTO modelo) {
		return sumaAseguradaDAO.devolverSumaAsegurada(modelo);
	}
	
}
