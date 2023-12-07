package gestores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import entidades.Premio;
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
	        poliza.getPorcentajeMedidas().add(medida.getValorActual());
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
        	cuota.setPoliza(poliza);
        	poliza.getCuotas().add(cuota);
        }
        
        //Logica premio
        Premio premio = new Premio();
        premio.setPrima(polizaDTO.getPremio().getPrima());
        premio.setDerechos_emision(polizaDTO.getPremio().getDerechoEmision());
        premio.setTotal(polizaDTO.getPremio().getTotal());
        premio.setPoliza(poliza);
        poliza.setPremio(premio);
        
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
	
	
	public static String generarNumeroPoliza() {
        Random random = new Random();
        int digito = 1 + random.nextInt(9); // Genera un dígito aleatorio del 1 al 9

        // Repite el dígito cuatro veces para obtener los primeros cuatro dígitos iguales
        String primerosCuatroDigitos = String.format("%04d", Integer.parseInt(String.valueOf(digito).repeat(4)));

        int siguientesSieteDigitos = 1000000 + random.nextInt(9000000);

        return String.format("%s%07d01", primerosCuatroDigitos, siguientesSieteDigitos);
    }
	
	
	public double calcularDescuentos() {
		Random random = new Random();
	    int premio = random.nextInt(4000 - 2000 + 1) + 2000;
		return premio;
	}
	
	
}
