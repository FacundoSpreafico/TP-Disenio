package entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "provincia")
public class Provincia {

	@Id
	@Column(name = "id_provincia")
	private Integer idProvincia;
	
	@Column(name = "nombre_provincia")
	private String nombreProvincia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pais")
	private Pais pais;
	
	@OneToMany(mappedBy = "provincia")
	private List<Localidad> localidades;
	
	public Provincia() {
		localidades = new ArrayList<Localidad>();
	}

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Localidad> getLocalidades() {
		return localidades;
	}

	public void setLocalidades(List<Localidad> localidades) {
		this.localidades = localidades;
	}

	@Override
	public String toString() {
		return "Provincia [idProvincia=" + idProvincia + ", nombreProvincia=" + nombreProvincia + "]";
	}
	
	
	
	
}
