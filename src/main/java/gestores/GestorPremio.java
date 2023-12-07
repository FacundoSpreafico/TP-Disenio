package gestores;

import java.util.Random;

import DTO.PremioDTO;

public class GestorPremio {
	private static GestorPremio _INSTANCE;

	public static GestorPremio getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorPremio();
		}
		return _INSTANCE;
	}
	
	public PremioDTO devolverPremio() {
		PremioDTO premio = new PremioDTO();
		Random random = new Random();
	    double prima = random.nextInt(10000 - 8000 + 1) + 8000;
		double derechoEmision = random.nextInt(2000 - 1000 + 1) + 1000;
		premio.setPrima(prima);
		premio.setDerechoEmision(derechoEmision);
		premio.setTotal(prima+derechoEmision);
		return premio;
	}
}
