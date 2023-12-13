package gestores;

import DAO.HijoClienteDAO;
import DAO.HijoClienteDAOImp;
import DTO.HijoClienteDTO;
import entidades.HijoCliente;

public class GestorHijoCliente {


	 private static GestorHijoCliente _INSTANCE;	
	 private HijoClienteDAO hijoClienteDAO = new HijoClienteDAOImp();

	 public static GestorHijoCliente getInstance() {
			if (_INSTANCE == null) {
				_INSTANCE = new GestorHijoCliente();
			}
			return _INSTANCE;
		}
	 

	public HijoCliente crearHijoCliente(HijoClienteDTO hijoDTO) {
        HijoCliente nuevoHijo = new HijoCliente(hijoDTO.getFechaNacimiento(),
                                                    hijoDTO.getSexo(),
                                                    hijoDTO.getEstadoCivil());
       return nuevoHijo; 
    }
}
