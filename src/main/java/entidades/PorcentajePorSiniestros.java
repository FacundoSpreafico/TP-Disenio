package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "porcentaje_por_siniestros")
public class PorcentajePorSiniestros {

	@Id
	@Column(name = "id_porcentaje_siniestros")
	private int idPorcentajeSiniestros;
	@Column(name = "cantidad_siniestros")
	private String cantidadSiniestros;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_por_siniestros")
	private HistorialPorcentajeSiniestros valorActual;

	public int getIdPorcentajeSiniestros() {
		return idPorcentajeSiniestros;
	}

	public void setIdPorcentajeSiniestros(int idPorcentajeSiniestros) {
		this.idPorcentajeSiniestros = idPorcentajeSiniestros;
	}

	public String getCantidadSiniestros() {
		return cantidadSiniestros;
	}

	public void setCantidadSiniestros(String cantidadSiniestros) {
		this.cantidadSiniestros = cantidadSiniestros;
	}

	public HistorialPorcentajeSiniestros getValorActual() {
		return valorActual;
	}

	public void setValorActual(HistorialPorcentajeSiniestros valorActual) {
		this.valorActual = valorActual;
	}
	
	
}
