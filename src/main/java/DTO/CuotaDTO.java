package DTO;

import java.util.Date;

import jakarta.persistence.Column;

public class CuotaDTO {

    private int orden;
	
	private Date fechaInicio;
	
	private Date fechaVencimiento;
	
	private float valorOriginal;
	
    private float valorActual;
    
	private float recargosMora;
	
	private float bonificacionPagoAdelantado;

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

	public Float getValorOriginal() {
		return valorOriginal;
	}

	public void setValorOriginal(Float valorOriginal) {
		this.valorOriginal = valorOriginal;
	}

	public float getValorActual() {
		return valorActual;
	}

	public void setValorActual(float valorActual) {
		this.valorActual = valorActual;
	}

	public float getRecargosMora() {
		return recargosMora;
	}

	public void setRecargosMora(float recargosMora) {
		this.recargosMora = recargosMora;
	}

	public float getBonificacionPagoAdelantado() {
		return bonificacionPagoAdelantado;
	}

	public void setBonificacionPagoAdelantado(float bonificacionPagoAdelantado) {
		this.bonificacionPagoAdelantado = bonificacionPagoAdelantado;
	}

	public void setValorOriginal(float valorOriginal) {
		this.valorOriginal = valorOriginal;
	}


	
	
}
