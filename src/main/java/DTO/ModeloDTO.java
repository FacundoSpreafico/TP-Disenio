package DTO;

public class ModeloDTO {
	private String nombreMarca;
	private String nombreModelo;
	private int anioFabricacion;
		
	
	public ModeloDTO() {
		
	}
	
	public ModeloDTO(String nombreMarca, String nombreModelo, int anioFabricacion) {
		this.nombreMarca = nombreMarca;
		this.nombreModelo = nombreModelo;
		this.anioFabricacion = anioFabricacion;
	}
	
	public String getNombreMarca() {
		return nombreMarca;
	}
	public void setNombre(String nombre) {
		this.nombreMarca = nombre;
	}
	public String getNombreModelo() {
		return nombreModelo;
	}
	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
=======

	private int idModelo;
	private int anioFabricacion;
	
	public int getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(int idModelo) {
		this.idModelo = idModelo;
>>>>>>> ramaNuevaFacu
	}
	public int getAnioFabricacion() {
		return anioFabricacion;
	}
	public void setAnioFabricacion(int anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
<<<<<<< HEAD
	}	
=======
	}

	
>>>>>>> ramaNuevaFacu
}
