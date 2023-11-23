package entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "marca")

public class Marca {
	@Id
	@Column(name = "id_marca")
	private int idMarca;
	
	@Column(name = "nombre_marca")
	private String nombreMarca;
	
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombreMarca(String marca) {
		this.nombreMarca = marca;
	}

	
	
	
	
}
