package DTO;

import java.util.ArrayList;
import java.util.List;

public class PolizaDTO {
	private Double sumaAsegurada;
	private List<HijoClienteDTO> hijos = new ArrayList<HijoClienteDTO>();;

	public Double getSumaAsegurada() {
		return sumaAsegurada;
	}

	public void setSumaAsegurada(Double sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public List<HijoClienteDTO> getHijos() {
		return hijos;
	}

	public void setHijos(List<HijoClienteDTO> hijos) {
		this.hijos = hijos;
	}
	
	
}