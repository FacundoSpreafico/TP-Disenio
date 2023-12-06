package gestores;

import java.util.Random;

public class GestorPremio {
	private static GestorPremio _INSTANCE;

	public static GestorPremio getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorPremio();
		}
		return _INSTANCE;
	}
	
	public double devolverPremio() {
		Random random = new Random();
	    double premio = random.nextInt(10000 - 8000 + 1) + 8000;
		return premio;
	}
}
