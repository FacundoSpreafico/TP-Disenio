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
@Table (name = "historial_estadistica_robo")

public class HistorialEstadisticaRobo {

	@Id
	@Column(name = "id_historial_estadistica_robo")
	private int idHistorialEstadisticaRobo;
	

	@Column(name = "desde")
	private Date fechaDesde;
	@Column(name = "hasta")
	private Date fechaHasta;
	@Column(name = "valor_porcentual")
	private double valorPorcentual;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modelo")
	private Modelo modelo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario operador;

	public int getIdHistorialEstadisticaRobo() {
		return idHistorialEstadisticaRobo;
	}

	public void setIdHistorialEstadisticaRobo(int idHistorialEstadisticaRobo) {
		this.idHistorialEstadisticaRobo = idHistorialEstadisticaRobo;
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

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Usuario getOperador() {
		return operador;
	}

	public void setOperador(Usuario operador) {
		this.operador = operador;
	}
	
}
