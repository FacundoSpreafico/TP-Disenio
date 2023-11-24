package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "porcentaje_por_hijo")
public class PorcentajePorHijo {

	@Id
	@Column(name = "id_porcentaje_hijo")
	private int idPorcentajeHijo;
	@Column(name = "cantidad_hijos")
	private String cantidadHijos;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_hijo")
	private HistorialPorcentajeHijo actual;
	
}
