package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "suma_asegurada")
public class SumaAsegurada {

	@Id
	@Column(name = "id_suma_asegurada")
	private int idSumaAsegurada;
	@Column(name = "anio_fabricacion")
	private int anioFabricacion;
	@Column(name = "monto")
	private double montoTotal;
	
	@ManyToOne
	@JoinColumn(name = "id_modelo")
	private Modelo modelo;
	
	
	public int getAnioFabricacion() {
		return anioFabricacion;
	}
	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	public double getMonto() {
		return montoTotal;
	}
	public void setMonto(double monto) {
		this.montoTotal = monto;
	}
	
}