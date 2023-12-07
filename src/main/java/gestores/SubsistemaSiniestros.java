package gestores;

import java.util.Random;

import DAO.ClienteDAOImp;

public class SubsistemaSiniestros {
	private static SubsistemaSiniestros _INSTANCE;
	
	public static SubsistemaSiniestros getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new SubsistemaSiniestros();
		}
		return _INSTANCE;
	}

	public int devolverCantidadSiniestros() {
		Random random = new Random();
        return  random.nextInt(4);
    }
}
