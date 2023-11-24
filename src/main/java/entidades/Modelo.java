package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "modelo")

public class Modelo {
	
	@Id
	@Column(name = "id_modelo")
	private int idModelo;
	@Column(name = "nombre_modelo")
	private String nombreModelo;
	@Column(name = "fabricacionDesde")
	private Integer aniofabricacionDesde;
	@Column(name = "fabricacionHasta")
	private Integer aniofabricacionHasta;
	@OneToOne
	private Marca marca;
	
	public String getNombreModelo() {
		return nombreModelo;
	}
	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}
	public Integer getAniofabricacionDesde() {
		return aniofabricacionDesde;
	}
	public void setAniofabricacionDesde(Integer aniofabricacionDesde) {
		this.aniofabricacionDesde = aniofabricacionDesde;
	}
	public Integer getAniofabricacionHasta() {
		return aniofabricacionHasta;
	}
	public void setAniofabricacionHasta(Integer aniofabricacionHasta) {
		this.aniofabricacionHasta = aniofabricacionHasta;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}

}
