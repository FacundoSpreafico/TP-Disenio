package DTO;

public class ClienteDTO {
	String nombre,apellido,tipoDocumento,nroCliente;
	Integer nroDocumento;
	public String getNroCliente() {
		return nroCliente;
	}
	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Integer getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(Integer nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
}
