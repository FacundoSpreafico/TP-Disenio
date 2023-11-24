package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "localidad")
public class Localidad {
	
	@Id
	@Column(name = "id_localidad")
	private Integer idLocalidad;
	
	@Column(name = "nombre_localidad")
	private String nombreLocalidad;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_provincia")
	private Provincia provincia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historial_porcentaje_riesgo")
	private HistorialPorcentajeRiesgo porcentaje;
	
	
	public Localidad() {
		
	}

	public Integer getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Integer idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return "Localidad [idLocalidad=" + idLocalidad + ", nombreLocalidad=" + nombreLocalidad + "]";
	}
	
	
}
