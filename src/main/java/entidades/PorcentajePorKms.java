package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "porcentaje_por_kms")
public class PorcentajePorKms {

	@Id
	@Column(name = "id_porcentaje_por_kms")
	private int idPorcentajePorKms;
	@Column(name = "cantidad_kilometros")
	private String rangoKms;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_kms")
	private HistorialPorcentajeKM valorActual;
}
