package DTO;

import java.util.Date;

import jakarta.persistence.Column;

public class CuotaDTO {

    private int orden;
	
	private Date fechaInicio;
	
	private Date fechaVencimiento;
	
	private double valorOriginal;
	
    private double valorActual;
    
	private double recargosMora;
	
	private double bonificacionPagoAdelantado;

	private String estado;

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public double getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(double valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public double getValorActual() {
		return valorActual;
	}

	public void setValorActual(double valorActual) {
		this.valorActual = valorActual;
	}

	public double getRecargosMora() {
		return recargosMora;
	}

	public void setRecargosMora(double recargosMora) {
		this.recargosMora = recargosMora;
	}

	public double getBonificacionPagoAdelantado() {
		return bonificacionPagoAdelantado;
	}

	public void setBonificacionPagoAdelantado(double bonificacionPagoAdelantado) {
		this.bonificacionPagoAdelantado = bonificacionPagoAdelantado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	
	
}
