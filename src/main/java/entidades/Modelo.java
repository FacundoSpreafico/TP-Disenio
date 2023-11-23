package entidades;

import jakarta.persistence.Entity;

@Entity

public class Modelo {
	private String nombreModelo;
	private Integer aniofabricacionDesde;
	private Integer aniofabricacionHasta;
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
