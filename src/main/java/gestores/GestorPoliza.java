package gestores;

import java.util.Random;

import DAO.PolizaDAO;
import DAO.PolizaDAOImp;
import DTO.ClienteDTO;
import DTO.PolizaDTO;
import DTO.VehiculoDTO;
import entidades.Cliente;
import entidades.Poliza;
import entidades.Vehiculo;

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
		Cliente cliente = GestorCliente.getInstance().obtenerPorId(clienteDTO);
		poliza.setCliente(cliente);
		Vehiculo vehiculo = GestorVehiculo.getInstance().crearVehiculo(vehiculoDTO);
		poliza.setVehiculo(vehiculo);
		
		
		poliza.setPorcentajeEstRobo(vehiculo.getModelo().getValorActual());
		System.out.print(poliza.getPorcentajeEstRobo());
		
		
		
		
		return "return";
	}
	
	
	public void setearAtributosSimples(Poliza poliza,PolizaDTO polizaDTO) {
		poliza.setNumeroPoliza(generarNumeroPoliza());
		poliza.setFechaInicio(polizaDTO.getFechaInicio());
		poliza.setVencimiento(polizaDTO.getVencimiento());	
		
		
		
	}
	
	 public String generarNumeroPoliza() {
		 final String LETRAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";   
		 Random random = new Random();
	     int numeroAleatorio = 1000000 + random.nextInt(9000000);

	     char letra1 = LETRAS.charAt(random.nextInt(LETRAS.length()));
	     char letra2 = LETRAS.charAt(random.nextInt(LETRAS.length()));

	     return String.format("%d%c%c", numeroAleatorio, letra1, letra2);
	    }
	
	
}
