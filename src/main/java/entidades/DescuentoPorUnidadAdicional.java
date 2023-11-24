package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "descuento_por_unidad_adicional")

public class DescuentoPorUnidadAdicional {

	
	@Id
	@Column(name = "id_descuento")
	private int idDescuento;
	@Column(name = "cantidad_unidades")
	private int cantUnidades;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_descuento_por_unidad_adicional")
	private HistorialDescuentoPorUnidadAdicional valorActual;
	
}
