package gestores;

import org.hibernate.Session;

import DAO.MedidaDeSeguridadDAO;
import DAO.MedidaDeSeguridadDAOImp;
import DAO.PolizaDAO;
import DAO.PolizaDAOImp;
import DAO.SessionHibernate;
import DTO.MedidaDeSeguridadDTO;
import entidades.MedidaDeSeguridad;
import jakarta.persistence.Query;

public class GestorMedidaSeguridad {
	
	 private static GestorMedidaSeguridad _INSTANCE;	
	 private MedidaDeSeguridadDAO medidaDAO = new MedidaDeSeguridadDAOImp();
	    
		public static GestorMedidaSeguridad getInstance() {
			if (_INSTANCE == null) {
				_INSTANCE = new GestorMedidaSeguridad();
			}
			return _INSTANCE;
		}
		
	 public MedidaDeSeguridad obtenerPorNombre(MedidaDeSeguridadDTO medida) {
		return medidaDAO.obtenerPorNombre(medida.getNombreMedida());
	 }
		
	
		
		
}
