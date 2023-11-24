package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cobertura")

public class Cobertura {

	@Column(name = "id_cobertura")
	private int idCobertura;
	@Column(name = "nombre_cobertura")
	private String nombreCobertura;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_cobertura")
	private HistorialPorcentajeCobertura valorActual;

	public String getNombreCobertura() {
		return nombreCobertura;
	}
	public void setNombreCobertura(String nombreCobertura) {
		this.nombreCobertura = nombreCobertura;
	}
}
