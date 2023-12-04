package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_marca")
	private Marca marca;
	
	@ManyToOne()
	@JoinColumn(name = "id_historial_estadistica_robo")
	private HistorialEstadisticaRobo valorActual;
	
	
	
	public int getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
	}
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
	public HistorialEstadisticaRobo getValorActual() {
		return valorActual;
	}
	public void setValorActual(HistorialEstadisticaRobo valorActual) {
		this.valorActual = valorActual;
	}

}
