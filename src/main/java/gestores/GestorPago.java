package gestores;


public class GestorPago {
	  private static GestorPago _INSTANCE;	
	    
		public static GestorPago getInstance() {
			if (_INSTANCE == null) {
				_INSTANCE = new GestorPago();
			}
			return _INSTANCE;
		}
		
}
