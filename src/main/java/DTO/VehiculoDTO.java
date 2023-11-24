package DTO;

public class VehiculoDTO {
	private String motor;
	private String chasis;
	private String patente;
	private String kmsUltAnio;
	private String nroSiniestros;
	private ModeloDTO modelo;
	private DomicilioRiesgoDTO domicilio;
	
	public void setIdModelo(int idModelo) {
		this.modelo.setIdModelo(idModelo);
	}
	
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public String getKmsUltAnio() {
		return kmsUltAnio;
	}
	public void setKmsUltAnio(String kmsUltAnio) {
		this.kmsUltAnio = kmsUltAnio;
	}
	public String getNroSiniestros() {
		return nroSiniestros;
	}
	public void setNroSiniestros(String nroSiniestros) {
		this.nroSiniestros = nroSiniestros;
	}
	public ModeloDTO getModelo() {
		return modelo;
	}
	public void setModelo(ModeloDTO modelo) {
		this.modelo = modelo;
	}
	public DomicilioRiesgoDTO getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(DomicilioRiesgoDTO domicilio) {
		this.domicilio = domicilio;
	}
	
	
}
