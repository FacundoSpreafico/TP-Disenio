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
@Table(name = "cuota")
public class Cuota {

	@Id
	@Column(name = "id_cuota")
	private Integer idCuota;
	
	@Column(name = "orden")
	private Integer orden;
	
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Column(name = "fecha_vencimiento")
	private Date fechaVencimiento;
	
	@Column(name = "valor_original")
	private Float valorOriginal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;
	//private Pago pago;
	@Column(name = "valor_actual")
	private Float valorActual;
	@Column(name = "recargos_mora")
	private Float recargosMora;
	@Column(name = "bonificacion_pago_adelantado")
	private Float bonificacionPagoAdelantado;
	
	public Integer getIdCuota() {
		return idCuota;
	}
	public void setIdCuota(Integer idCuota) {
		this.idCuota = idCuota;
	}
	public Integer getOrden() {
		return orden;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public Float getValorOriginal() {
		return valorOriginal;
	}
	public void setValorOriginal(Float valorOriginal) {
		this.valorOriginal = valorOriginal;
	}
	public Poliza getPoliza() {
		return poliza;
	}
	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}
	public Float getValorActual() {
		return valorActual;
	}
	public void setValorActual(Float valorActual) {
		this.valorActual = valorActual;
	}
	public Float getRecargosMora() {
		return recargosMora;
	}
	public void setRecargosMora(Float recargosMora) {
		this.recargosMora = recargosMora;
	}
	public Float getBonificacionPagoAdelantado() {
		return bonificacionPagoAdelantado;
	}
	public void setBonificacionPagoAdelantado(Float bonificacionPagoAdelantado) {
		this.bonificacionPagoAdelantado = bonificacionPagoAdelantado;
	}
	
	
}
