package entidades;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pago")
public class Pago {
	
	@Id
	@Column(name = "nro_recibo")
	private Integer nroRecibo;
	
	@Column(name = "hora")
	@Temporal(TemporalType.TIMESTAMP)
	private Timestamp hora;
	
	@Column(name = "mes")
	private String mes;
	
	@Column(name = "anio")
	private Integer anio;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "pago", cascade = CascadeType.ALL)
	private List<Cuota> cuotasPagadas = new ArrayList<Cuota>();

	
	public Integer getNroRecibo() {
		return nroRecibo;
	}

	public void setNroRecibo(Integer nroRecibo) {
		this.nroRecibo = nroRecibo;
	}

	public Timestamp getHora() {
		return hora;
	}

	public void setHora(Timestamp hora) {
		this.hora = hora;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Cuota> getCuotasPagadas() {
		return cuotasPagadas;
	}

	public void setCuotasPagadas(List<Cuota> cuotasPagadas) {
		this.cuotasPagadas = cuotasPagadas;
	}
	
}
