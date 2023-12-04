package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.Cuota;

public class PolizaDTO {

	private Double sumaAsegurada;	
	private List<MedidaDeSeguridadDTO> medidasDeclaradas = new ArrayList<>();
	private List<HijoClienteDTO> hijos = new ArrayList<>();
	private List<CuotaDTO> cuotas = new ArrayList<>();
	private CoberturaDTO cobertura = new CoberturaDTO();
	private Date vencimiento;
	private Date fechaInicio;
	private String cantKmsUltimoAnio;
	
	public CoberturaDTO getCobertura() {
		return cobertura;
	}
	public void setCobertura(CoberturaDTO cobertura) {
		this.cobertura = cobertura;
	}
	public Date getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	
	
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
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getKmsUltAnio() {
		return cantKmsUltimoAnio;
	}
	public void setKmsUltAnio(String kmsUltAnio) {
		this.cantKmsUltimoAnio = kmsUltAnio;
	}
	public List<CuotaDTO> getCuotas() {
		return cuotas;
	}
	public void setCuotas(List<CuotaDTO> cuotas) {
		this.cuotas = cuotas;
	}



}