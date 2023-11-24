package gestores;

import java.util.Random;

import DAO.PolizaDAO;
import DAO.PolizaDAOImp;
import DTO.ClienteDTO;
import DTO.PolizaDTO;
import DTO.VehiculoDTO;
import entidades.Poliza;

public class GestorPoliza {

    private static GestorPoliza _INSTANCE;	
	private PolizaDAO polizaDAO = new PolizaDAOImp();
    
	public static GestorPoliza getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorPoliza();
		}
		return _INSTANCE;
	}
	
	public String darAltaPoliza(PolizaDTO polizaDTO,ClienteDTO clienteDTO,VehiculoDTO vehiculoDTO) {
		int numeroPoliza;
		Poliza poliza = new Poliza();
		setearAtributosSimples(poliza,polizaDTO);
		
		
		
		return "return";
	}
	
	
	public void setearAtributosSimples(Poliza poliza,PolizaDTO polizaDTO) {
		poliza.setNumeroPoliza(generarNumeroPoliza());
		poliza.setVencimiento(null);
		
		
	}
	
	 public String generarNumeroPoliza() {
		 final String LETRAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";   
		 Random random = new Random();
	     int numeroAleatorio = 1000000 + random.nextInt(9000000);

	     char letra1 = LETRAS.charAt(random.nextInt(LETRAS.length()));
	     char letra2 = LETRAS.charAt(random.nextInt(LETRAS.length()));

	     // Combinar dígitos y letras
	     return String.format("%d%c%c", numeroAleatorio, letra1, letra2);
	    }
	
	
}
