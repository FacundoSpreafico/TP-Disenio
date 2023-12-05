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
@Table (name = "historial_porcentaje_cobertura")
public class HistorialPorcentajeCobertura {

	

	@Id
	@Column(name = "id_historial_porcentaje_cobertura")
	private int idHistorialPorcentajeCobertura;
	
	@Column(name = "desde")
	private Date fechaDesde;
	@Column(name = "hasta")
	private Date fechaHasta;
	@Column(name = "valor_porcentual")
	private double valorPorcentual;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cobertura")
	private Cobertura cobertura;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario operador;
	public int getIdHistorialPorcentajeCobertura() {
		return idHistorialPorcentajeCobertura;
	}
	public void setIdHistorialPorcentajeCobertura(int idHistorialPorcentajeCobertura) {
		this.idHistorialPorcentajeCobertura = idHistorialPorcentajeCobertura;
	}
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public double getValorPorcentual() {
		return valorPorcentual;
	}
	public void setValorPorcentual(double valorPorcentual) {
		this.valorPorcentual = valorPorcentual;
	}
	public Cobertura getCobertura() {
		return cobertura;
	}
	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}
	public Usuario getOperador() {
		return operador;
	}
	public void setOperador(Usuario operador) {
		this.operador = operador;
	}
	
	
}
