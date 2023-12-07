package entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuota")
public class Cuota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cuota")
	private int idCuota;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "orden")
	private int orden;
	
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Column(name = "fecha_vencimiento")
	private Date fechaVencimiento;
	
	@Column(name = "valor_original")
	private double valorOriginal;
	
	@ManyToOne()
	@JoinColumn(name = "id_poliza")
	private Poliza poliza;
	
	@ManyToOne
	@JoinColumn(name = "id_pago")
    private Pago pago;
	
	@Column(name = "valor_actual")
	private double valorActual;
	
	@Column(name = "recargos_mora")
	private double recargosMora;
	
	@Column(name = "bonificacion_pago_adelantado")
	private double bonificacionPagoAdelantado;

	public int getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
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

	public double getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public Poliza getPoliza() {
		return poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public double getValorActual() {
		return valorActual;
	}

	public void setValorActual(double valorActual) {
		this.valorActual = valorActual;
	}

	public double getRecargosMora() {
		return recargosMora;
	}

	public void setRecargosMora(double recargosMora) {
		this.recargosMora = recargosMora;
	}

	public double getBonificacionPagoAdelantado() {
		return bonificacionPagoAdelantado;
	}

	public void setBonificacionPagoAdelantado(double bonificacionPagoAdelantado) {
		this.bonificacionPagoAdelantado = bonificacionPagoAdelantado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
		
	}
	

	
}
