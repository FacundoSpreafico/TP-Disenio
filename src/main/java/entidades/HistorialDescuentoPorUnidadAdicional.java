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
@Table (name = "historial_descuento_por_unidad_adicional")

public class HistorialDescuentoPorUnidadAdicional {

	
	@Id
	@Column(name = "id_historial_descuento_por_unidad_adicional")
	private int idHistorialDescuentoPorUnidadAdicional;
	
	@Column(name = "desde")
	private Date fechaDesde;
	@Column(name = "hasta")
	private Date fechaHasta;
	@Column(name = "valor_porcentual")
	private double valorPorcentual;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_descuento")
	private DescuentoPorUnidadAdicional descuento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario operador;

	public int getIdHistorialDescuentoPorUnidadAdicional() {
		return idHistorialDescuentoPorUnidadAdicional;
	}

	public void setIdHistorialDescuentoPorUnidadAdicional(int idHistorialDescuentoPorUnidadAdicional) {
		this.idHistorialDescuentoPorUnidadAdicional = idHistorialDescuentoPorUnidadAdicional;
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

	public DescuentoPorUnidadAdicional getDescuento() {
		return descuento;
	}

	public void setDescuento(DescuentoPorUnidadAdicional descuento) {
		this.descuento = descuento;
	}

	public Usuario getOperador() {
		return operador;
	}

	public void setOperador(Usuario operador) {
		this.operador = operador;
	}
	
}
