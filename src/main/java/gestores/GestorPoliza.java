package gestores;

import DAO.PolizaDAO;
import DAO.PolizaDAOImp;

public class GestorPoliza {

    private static GestorPoliza _INSTANCE;	
	private PolizaDAO polizaDAO = new PolizaDAOImp();
    
	public static GestorPoliza getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorPoliza();
		}
		return _INSTANCE;
	}
	
	
	
	
}
