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
	private Date fechaInicio;
	private Date fechaFin;
	private String cantKms;
	private String formaPago;
	private boolean renovar;
	private String nroSiniestros;
	private String estadoPoliza;
	private PremioDTO premio = new PremioDTO();
	

	public PremioDTO getPremio() {
		return premio;
	}
	public void setPremio(Double prima) {
		this.premio.setPrima(prima);
	}
	public CoberturaDTO getCobertura() {
		return cobertura;
	}
	public void setCobertura(CoberturaDTO cobertura) {
		this.cobertura = cobertura;
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
		return cantKms;
	}
	public void setKmsUltAnio(String kmsUltAnio) {
		this.cantKms = kmsUltAnio;
	}
	public List<CuotaDTO> getCuotas() {
		return cuotas;
	}
	public void setCuotas(List<CuotaDTO> cuotas) {
		this.cuotas = cuotas;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getCantKms() {
		return cantKms;
	}
	public void setCantKms(String cantKms) {
		this.cantKms = cantKms;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public boolean isRenovar() {
		return renovar;
	}
	public void setRenovar(boolean renovar) {
		this.renovar = renovar;
	}
	public String getNroSiniestros() {
		return nroSiniestros;
	}
	public void setNroSiniestros(String nroSiniestros) {
		this.nroSiniestros = nroSiniestros;
	}
	public String getEstadoPoliza() {
		return estadoPoliza;
	}
	public void setEstadoPoliza(String estadoPoliza) {
		this.estadoPoliza = estadoPoliza;
	}
	
	
	
	
	
}