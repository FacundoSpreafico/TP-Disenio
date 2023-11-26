package DTO;

public class DomicilioRiesgoDTO {
	private String pais;
	private String provincia;
	private String localidad;
	
	public DomicilioRiesgoDTO() {
		
	}
	
	public DomicilioRiesgoDTO(String pais, String provincia, String localidad) {
		this.pais = pais;
		this.provincia = provincia;
		this.localidad = localidad;
	}
	
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
}
