package gestores;


import DAO.SumaAseguradaDAO;
import DAO.SumaAseguradaDAOImp;
import DTO.ModeloDTO;
import entidades.SumaAsegurada;


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
		try { 
		return sumaAseguradaDAO.devolverSumaAsegurada(modelo.getNombreModelo(),modelo.getAnioFabricacion()).getMonto();
		}
		catch(Exception e) {
		}
		return 0;
	}

	public SumaAsegurada obtenerSumaAsegurada (ModeloDTO modelo) {
		return sumaAseguradaDAO.devolverSumaAsegurada(modelo.getNombreModelo(),modelo.getAnioFabricacion());
	}
	

}