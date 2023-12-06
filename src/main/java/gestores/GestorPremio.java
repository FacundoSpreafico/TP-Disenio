package gestores;

public class GestorPremio {
	private static GestorPremio _INSTANCE;

	public static GestorPremio getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorPremio();
		}
		return _INSTANCE;
	}
	
	public String devolverPremio() {
		return null;
		
		
		
		
		
	}
}
