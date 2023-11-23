package DTO;

public class VehiculoDTO {
	private String motor;
	private String chasis;
	private String patente;
	private Integer kmsUltAnio;
	private String nroSiniestros;
	private MarcaDTO marca;
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
	public Integer getKmsUltAnio() {
		return kmsUltAnio;
	}
	public void setKmsUltAnio(Integer kmsUltAnio) {
		this.kmsUltAnio = kmsUltAnio;
	}
	public String getNroSiniestros() {
		return nroSiniestros;
	}
	public void setNroSiniestros(String nroSiniestros) {
		this.nroSiniestros = nroSiniestros;
	}
	public MarcaDTO getMarca() {
		return marca;
	}
	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}
	
	
}
