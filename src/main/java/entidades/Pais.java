package entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "pais")

public class Pais {
	
	@Id
	@Column(name = "id_pais")
	private Integer idPais;
	
	@Column(name = "nombre_pais")
	private String nombrePais;
	
	@OneToMany(mappedBy = "pais")
	private List<Provincia> provincias = new ArrayList<Provincia>();
	
	/*public Pais() {
		provincias = new ArrayList<Provincia>();
	}*/

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}

	@Override
	public String toString() {
		return "Pais [idPais=" + idPais + ", nombrePais=" + nombrePais + "]";
	}

	
	
	
	
}
