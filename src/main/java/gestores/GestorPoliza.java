package gestores;

import java.util.Calendar;
import java.util.Random;

import DAO.PolizaDAO;
import DAO.PolizaDAOImp;
import DTO.ClienteDTO;
import DTO.CuotaDTO;
import DTO.HijoClienteDTO;
import DTO.MedidaDeSeguridadDTO;
import DTO.PolizaDTO;
import DTO.VehiculoDTO;
import entidades.Cliente;
import entidades.Cobertura;
import entidades.Cuota;
import entidades.HijoCliente;
import entidades.HistorialDerechoEmision;
import entidades.HistorialDescuentoPorUnidadAdicional;
import entidades.HistorialPorcentajeHijo;
import entidades.HistorialPorcentajeKM;
import entidades.HistorialPorcentajeSiniestros;
import entidades.MedidaDeSeguridad;
import entidades.Poliza;
import entidades.SumaAsegurada;
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
		//Creamos la entidad poliza
		Poliza poliza = new Poliza();
	
		//Seteamos atributos simples
		setearAtributosSimples(poliza,polizaDTO);
		
		//Logica del cliente
		Cliente cliente = GestorCliente.getInstance().obtenerPorId(clienteDTO);
		poliza.setCliente(cliente);
		
		//Logica del vehiculo
		Vehiculo vehiculo = GestorVehiculo.getInstance().crearVehiculo(vehiculoDTO);
		poliza.setVehiculo(vehiculo);
		
		//Logica porcentaje estadistica robo
		poliza.setPorcentajeEstRobo(vehiculo.getModelo().getValorActual());
		
		//Logica porcentaje riesgo
		poliza.setPorcentajeRiesgo(vehiculo.getLocalidad().getPorcentaje());
		
		//Faltan demas historiales
		
		//Logica suma asegurada
	    SumaAsegurada sumaAsegurada = GestorSumaAsegurada.getInstance().obtenerSumaAsegurada(vehiculoDTO.getModelo());
	    poliza.setSumaAsegurada(sumaAsegurada);
	    
	    //Logica medidas de seguridad
	    for (MedidaDeSeguridadDTO medidaDTO: polizaDTO.getMedidasDeclaradas()) {
	    	MedidaDeSeguridad medida;
	    	medida = GestorMedidaSeguridad.getInstance().obtenerPorNombre(medidaDTO);
	        poliza.getMedidas().add(medida);
	    }
	    
	    
	    //Logica hijos
        for(HijoClienteDTO hijoDTO : polizaDTO.getHijos()) {
        	HijoCliente hijo;
            hijo = GestorHijoCliente.getInstance().crearHijoCliente(hijoDTO);
    	    poliza.getHijos().add(hijo);
        }
        
        //Logica cobertura
        Cobertura cobertura = GestorCobertura.getInstance().buscarCobertura(polizaDTO.getCobertura().getNombreCobertura());
        poliza.setTipoCobertura(cobertura);
        poliza.setPorcentajeCobertura(cobertura.getValorActual());
        
        //Logica cuotas
        for (CuotaDTO cuotaDTO: polizaDTO.getCuotas()) {
        	Cuota cuota;
        	cuota = GestorCuota.getInstance().crearCuota(cuotaDTO);
        	poliza.getCuotas().add(cuota);
        }
        
        
        //Recuperar historial porcentaje kilometros
        HistorialPorcentajeKM historialKms = 
        GestorPorcentajeKms.getInstance().getHistorialActual(polizaDTO.getKmsUltAnio());
        poliza.setPorcentajeKMs(historialKms);

        
        //Recuperar historial porcentaje siniestros
        HistorialPorcentajeSiniestros historialSiniestros = 
        GestorPorcentajeSiniestros.getInstance().getHistorialActual(polizaDTO.getNroSiniestros());
        poliza.setPorcentajeSiniestros(historialSiniestros);
	    
        //Recuperar historial porcentaje hijos
        HistorialPorcentajeHijo historialHijos = 
        GestorPorcentajeHijo.getInstance().getHistorialActual(polizaDTO.getHijos().size());
        poliza.setPorcentajeHijo(historialHijos);
        
        //Recuperar historial derecho emision
        HistorialDerechoEmision historialDerechoEmision = 
        GestorDerechoEmision.getInstance().getHistorialActual();
        poliza.setPorcentajeDerechoEmision(historialDerechoEmision);
        
        //Recuperar historial descuento por unidad adicional
        Long cantidadVehiculos = GestorCliente.getInstance().obtenerCantidadVehiculos(clienteDTO.getIdCliente());
        HistorialDescuentoPorUnidadAdicional historialDescuentoPorUnidadAdicional = 
        GestorDescuentoPorUnidAdicional.getInstance().getHistorialActual(cantidadVehiculos);
        poliza.setPorcentajeDescuento(historialDescuentoPorUnidadAdicional);
        
        polizaDAO.insertarPoliza(poliza);
       
	    
		return poliza.getNumeroPoliza();
	}
	
	
	public void setearAtributosSimples(Poliza poliza,PolizaDTO polizaDTO) {
		poliza.setNumeroPoliza(generarNumeroPoliza());
		poliza.setFechaInicio(polizaDTO.getFechaInicio());
		poliza.setFechaFin(polizaDTO.getFechaFin());
    	poliza.setFormaPago(polizaDTO.getFormaPago());
    	poliza.setRenovar(polizaDTO.isRenovar());
    	poliza.setEstadoPoliza(polizaDTO.getEstadoPoliza());
    	poliza.setNroSiniestros(polizaDTO.getNroSiniestros());
		poliza.setCantKmsPorAnio(polizaDTO.getCantKms());
		poliza.setFechaEmision(Calendar.getInstance().getTime());
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
