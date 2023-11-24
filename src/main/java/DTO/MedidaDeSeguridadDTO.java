package DTO;

public class MedidaDeSeguridadDTO {

	private String nombreMedida;

	public MedidaDeSeguridadDTO(String medida) {
		this.nombreMedida = medida;
	}
	public String getNombreMedida() {
		return nombreMedida;
	}
	public void setNombreMedida(String nombreMedida) {
		this.nombreMedida = nombreMedida;
	}
	
}
