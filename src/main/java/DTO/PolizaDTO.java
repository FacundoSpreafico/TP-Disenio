package DTO;

import java.util.ArrayList;
import java.util.List;

public class PolizaDTO {

	private Double sumaAsegurada;	
	private List<MedidaDeSeguridadDTO> medidasDeclaradas = new ArrayList<>();
	private List<HijoClienteDTO> hijos = new ArrayList<>();
	private CoberturaDTO cobertura = new CoberturaDTO();
	
	
	public List<HijoClienteDTO> getHijos() {
		return hijos;
	}
	public void setHijos(List<HijoClienteDTO> listaDTO) {
	this.hijos = listaDTO;	
	}
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