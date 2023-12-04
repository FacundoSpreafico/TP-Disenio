package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "Poliza")

public class Poliza {

	@Id
	@Column(name = "id_poliza")
	private int idPoliza;
	
	@Column(name = "numero")
	private String numeroPoliza;
	
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Column(name = "fecha_emision")
	private Date fechaEmision;
	
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
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "id_vehiculo")
	private Vehiculo vehiculo;
	
	@ManyToOne()
	@JoinColumn(name = "id_cobertura")
	private Cobertura tipoCobertura;
	
	@ManyToOne()
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne()
	@JoinColumn(name = "id_suma_asegurada")
	private SumaAsegurada sumaAsegurada;
	
	@ManyToMany()
	@JoinTable (name = "declara_medida", joinColumns = {@JoinColumn(name = "id_poliza")}, inverseJoinColumns = {@JoinColumn (name = "id_medida")})
    private List<MedidaDeSeguridad> medidas = new ArrayList<>();
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_porcentaje_riesgo")
	private HistorialPorcentajeRiesgo porcentajeRiesgo;
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_descuento_por_unidad_adicional")
	private HistorialDescuentoPorUnidadAdicional porcentajeDescuento;
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_porcentaje_hijo")
	private HistorialPorcentajeHijo porcentajeHijo;
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_estadistica_robo")
	private HistorialEstadisticaRobo porcentajeEstRobo;
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_porcentaje_cobertura")
	private HistorialPorcentajeCobertura porcentajeCobertura;
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_derecho_emision")
	private HistorialDerechoEmision porcentajeDerechoEmision;
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_porcentaje_por_siniestros")
	private HistorialPorcentajeSiniestros porcentajeSiniestros;
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_porcentaje_kms")
	private HistorialPorcentajeKM porcentajeKMs;
	
	@ManyToOne()
	@JoinColumn(name = "id_ultima_modificacion")
	private HistorialPolizaModificada ultimaModificacion;
	
	@OneToMany(mappedBy = "poliza")
	private List<Cuota> cuotas = new ArrayList<>();

	@ManyToMany()
	@JoinTable (name = "registrado_en", joinColumns = {@JoinColumn(name = "id_poliza")}, inverseJoinColumns = {@JoinColumn (name = "id_hijo_cliente")})
    private List<HijoCliente> hijos = new ArrayList<>();
	
	public int getIdPoliza() {
		return idPoliza;
	}

	public void setIdPoliza(int idPoliza) {
		this.idPoliza = idPoliza;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Date getUltimoDiaPago() {
		return ultimoDiaPago;
	}

	public void setUltimoDiaPago(Date ultimoDiaPago) {
		this.ultimoDiaPago = ultimoDiaPago;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public String getNroSiniestros() {
		return nroSiniestros;
	}

	public void setNroSiniestros(String nroSiniestros) {
		this.nroSiniestros = nroSiniestros;
	}

	public String getEstadoPoliza() {
		return estadoPoliza;
	}

	public void setEstadoPoliza(String estadoPoliza) {
		this.estadoPoliza = estadoPoliza;
	}

	public int getCantKmsPorAnio() {
		return cantKmsPorAnio;
	}

	public void setCantKmsPorAnio(int cantKmsPorAnio) {
		this.cantKmsPorAnio = cantKmsPorAnio;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cobertura getTipoCobertura() {
		return tipoCobertura;
	}

	public void setTipoCobertura(Cobertura tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public SumaAsegurada getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(SumaAsegurada sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public HistorialPolizaModificada getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(HistorialPolizaModificada ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}

	public Boolean getRenovar() {
		return renovar;
	}

	public void setRenovar(Boolean renovar) {
		this.renovar = renovar;
	}

	public HistorialPorcentajeRiesgo getPorcentajeRiesgo() {
		return porcentajeRiesgo;
	}

	public void setPorcentajeRiesgo(HistorialPorcentajeRiesgo porcentajeRiesgo) {
		this.porcentajeRiesgo = porcentajeRiesgo;
	}

	public HistorialDescuentoPorUnidadAdicional getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(HistorialDescuentoPorUnidadAdicional porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}

	public HistorialPorcentajeHijo getPorcentajeHijo() {
		return porcentajeHijo;
	}

	public void setPorcentajeHijo(HistorialPorcentajeHijo porcentajeHijo) {
		this.porcentajeHijo = porcentajeHijo;
	}

	public HistorialEstadisticaRobo getPorcentajeEstRobo() {
		return porcentajeEstRobo;
	}

	public void setPorcentajeEstRobo(HistorialEstadisticaRobo porcentajeEstRobo) {
		this.porcentajeEstRobo = porcentajeEstRobo;
	}

	public HistorialPorcentajeCobertura getPorcentajeCobertura() {
		return porcentajeCobertura;
	}

	public void setPorcentajeCobertura(HistorialPorcentajeCobertura porcentajeCobertura) {
		this.porcentajeCobertura = porcentajeCobertura;
	}

	public HistorialDerechoEmision getPorcentajeDerechoEmision() {
		return porcentajeDerechoEmision;
	}

	public void setPorcentajeDerechoEmision(HistorialDerechoEmision porcentajeDerechoEmision) {
		this.porcentajeDerechoEmision = porcentajeDerechoEmision;
	}

	public HistorialPorcentajeSiniestros getPorcentajeSiniestros() {
		return porcentajeSiniestros;
	}

	public void setPorcentajeSiniestros(HistorialPorcentajeSiniestros porcentajeSiniestros) {
		this.porcentajeSiniestros = porcentajeSiniestros;
	}

	public HistorialPorcentajeKM getPorcentajeKMs() {
		return porcentajeKMs;
	}

	public void setPorcentajeKMs(HistorialPorcentajeKM porcentajeKMs) {
		this.porcentajeKMs = porcentajeKMs;
	}

	public List<MedidaDeSeguridad> getMedidas() {
		return medidas;
	}

	public void setMedidas(List<MedidaDeSeguridad> medidas) {
		this.medidas = medidas;
	}

	public List<HijoCliente> getHijos() {
		return hijos;
	}

	public void setHijos(List<HijoCliente> hijos) {
		this.hijos = hijos;
	}

	public List<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(List<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	
	
}
