package entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "historial_poliza_modificada")

public class HistorialPolizaModificada {


	@Id
	@Column(name = "id_historial_poliza_modificada")
	private int idHistorialPolizaModificada;
	
	@Column(name = "desde")
	private Date fechaDesde;
	@Column(name = "hasta")
	private Date fechaHasta;
	@Column(name = "nro_siniestros")
	private String nroSiniestros;
	@Column(name = "motor")
	private String motor;
	@Column(name = "chasis")
	private String chasis;
	@Column(name = "renovar")
	private Boolean renovar;
	@Column(name = "patente")
	private String patente;
	@Column(name = "estado_poliza")
	private String estadoPoliza;
	@Column(name = "cantidad_kms_por_anio")
	private String kilometrosPorAnio;
	@Column(name = "anio_vehiculo")
	private int anioVehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cobertura")
	private Cobertura nuevaCobertura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;
	
	//@ManyToOne()
	//@JoinColumn(name = "id_usuario")
	//private Usuario operador;
	
}
