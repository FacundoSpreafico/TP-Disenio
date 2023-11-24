package DTO;

import java.util.Date;

public class HijoClienteDTO {
	private String sexo;
	private String estadoCivil;
	private Date fechaNacimiento;
	
	public HijoClienteDTO() {	
	}
	
	public HijoClienteDTO(Date fechaNacimiento, String sexo, String estadoCivil) {
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
	}
	
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
}
