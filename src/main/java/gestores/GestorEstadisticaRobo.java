package gestores;


public class GestorEstadisticaRobo {
	  private static GestorEstadisticaRobo _INSTANCE;	
	    
		public static GestorEstadisticaRobo getInstance() {
			if (_INSTANCE == null) {
				_INSTANCE = new GestorEstadisticaRobo();
			}
			return _INSTANCE;
		}
		
}
