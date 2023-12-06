package DTO;

public class DomicilioDTO {
     String calle;
     int altura;

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
    
	public String devolverDomicilio() {
		return this.calle + " " + (String.valueOf(this.altura));
	}

     
}
