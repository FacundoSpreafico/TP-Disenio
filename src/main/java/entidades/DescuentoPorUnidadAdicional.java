package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	private String cantUnidades;
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_descuento_por_unidad_adicional")
	private HistorialDescuentoPorUnidadAdicional valorActual;

	public int getIdDescuento() {
		return idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	public String getCantUnidades() {
		return cantUnidades;
	}

	public void setCantUnidades(String cantUnidades) {
		this.cantUnidades = cantUnidades;
	}

	public HistorialDescuentoPorUnidadAdicional getValorActual() {
		return valorActual;
	}

	public void setValorActual(HistorialDescuentoPorUnidadAdicional valorActual) {
		this.valorActual = valorActual;
	}
	
	
}
