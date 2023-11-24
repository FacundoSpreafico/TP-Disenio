package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "medida_de_seguridad")

public class MedidaDeSeguridad {

	@Id
	@Column(name = "id_medida")
	private int idMedida;
	@Column(name = "tipo_medida")
	private String nombreMedida;
	
	
	
}
