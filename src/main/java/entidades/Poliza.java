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
@Table (name = "Poliza")

public class Poliza {

	@Id
	@Column(name = "id_poliza")
	private int idPoliza;
	@Column(name = "numero")
	private String numero;
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	@Column(name = "fecha_fin")
	private Date fechaFin;
	@Column(name = "fecha_emision")
	private float fechaEmision;
	@Column(name = "forma_pago")
	private String formaPago;
	@Column(name = "ultimo_dia_pago")
	private Date ultimoDiaPago;
	@Column(name = "renovar")
	private Boolean renovar;
	@Column(name = "vencimiento")
	private Date vencimiento;
	@Column(name = "nro_siniestros")
	private String nroSiniestros;
	@Column(name = "estado_poliza")
	private String estadoPoliza;
	@Column(name = "cantidad_kms_por_anio")
	private int cantKmsPorAnio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo vehiculo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cobertura")
	private Cobertura tipoCobertura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_suma_asegurada")
	private SumaAsegurada sumaAsegurada;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_riesgo")
	private HistorialPorcentajeRiesgo porcentajeRiesgo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_descuento_por_unidad_adicional")
	private HistorialDescuentoPorUnidadAdicional porcentajeDescuento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_hijo")
	private HistorialPorcentajeHijo porcentajeHijo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_estadistica_robo")
	private HistorialEstadisticaRobo porcentajeEstRobo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_cobertura")
	private HistorialPorcentajeCobertura porcentajeCobertura;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_derecho_emision")
	private HistorialDerechoEmision porcentajeDerechoEmision;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_por_siniestros")
	private HistorialPorcentajeSiniestros porcentajeSiniestros;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_kms")
	private HistorialPorcentajeKM porcentajeKMs;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ultima_modificacion")
	private HistorialPolizaModificada ultimaModificacion;
	
	/*falta mapear la tabla porcentaje_medidas salida de la relacion de
	poliza junto con historial_porcentaje_medidas
	*/
}
