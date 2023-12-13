package gestores;

public class GestorUsuario {
	private static GestorUsuario _INSTANCE;	
    
	public static GestorUsuario getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorUsuario();
		}
		return _INSTANCE;
	}
	
}
