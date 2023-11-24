package DTO;

import java.util.ArrayList;
import java.util.List;

public class PolizaDTO {
	
	private Double sumaAsegurada;	
	private List<MedidaDeSeguridadDTO> medidasDeclaradas = new ArrayList<>();
	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}
	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}
	public List<MedidaDeSeguridadDTO> getMedidasDeclaradas() {
		return medidasDeclaradas;
	}
	public void setMedidasDeclaradas(List<MedidaDeSeguridadDTO> medidasDeclaradas) {
		this.medidasDeclaradas = medidasDeclaradas;
	}

	
	
}