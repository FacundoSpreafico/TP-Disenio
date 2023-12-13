package gestores;

import DAO.CuotaDAO;
import DAO.CuotaDAOImp;
import DTO.CuotaDTO;
import entidades.Cuota;

public class GestorCuota {
	  private static GestorCuota _INSTANCE;	
	  private CuotaDAO cuotaDAO= new CuotaDAOImp();
	    
		public static GestorCuota getInstance() {
			if (_INSTANCE == null) {
				_INSTANCE = new GestorCuota();
			}
			return _INSTANCE;
		}
		
	public Cuota crearCuota (CuotaDTO cuota) {
		return cuotaDAO.crearCuota(cuota);
		
	}
		
}
