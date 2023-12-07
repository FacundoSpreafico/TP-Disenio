package DTO;

public class DescuentoTotalDTO {

	
	private double descuentoPorUnidadAdicional = 0;
	private double descuentoPorSemestralidad = 0;
	
	
	
	public double devolverTotal() {
		if (descuentoPorSemestralidad != 0) {
		return this.descuentoPorSemestralidad + this.descuentoPorUnidadAdicional;
		}
		else {
		return this.descuentoPorUnidadAdicional;
		}
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
