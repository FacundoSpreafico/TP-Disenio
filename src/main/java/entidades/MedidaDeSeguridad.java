package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table (name = "medida_de_seguridad")

public class MedidaDeSeguridad {
	@Id
	@Column(name = "id_medida")
	private int idMedida;
	@Column(name = "tipo_medida")
	private String nombreMedida;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_medida")
	private HistorialPorcentajeMedida valorActual;
	
	
}
