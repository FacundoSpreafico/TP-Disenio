package DTO;

public class DescuentoTotalDTO {

	
	private double descuentoPorUnidadAdicional;
	private double descuentoPorSemestralidad;
	
	
	
	public double devolverTotal() {
		return this.descuentoPorSemestralidad + this.descuentoPorUnidadAdicional;
	}
	
	public double getDescuentoPorUnidadAdicional() {
		return descuentoPorUnidadAdicional;
	}
	public void setDescuentoPorUnidadAdicional(double descuentoPorUnidadAdicional) {
		this.descuentoPorUnidadAdicional = descuentoPorUnidadAdicional;
	}
	public double getDescuentoPorSemestralidad() {
		return descuentoPorSemestralidad;
	}
	public void setDescuentoPorSemestralidad(double descuentoPorSemestralidad) {
		this.descuentoPorSemestralidad = descuentoPorSemestralidad;
	}
	
	
	
}
