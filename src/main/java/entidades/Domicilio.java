package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "domicilio")
public class Domicilio {
	
	@Id
	private Integer idCliente;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "altura")
	private Integer altura;
	
	@Column(name = "piso")
	private Integer piso;
	
	@Column(name = "departamento")
	private String departamento;
	
	@Column(name = "codigo_postal")
	private Integer codigo_postal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_localidad")
	private Localidad Integer;
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Integer getCodigo_postal() {
		return codigo_postal;
	}

	public void setCodigo_postal(Integer codigo_postal) {
		this.codigo_postal = codigo_postal;
	}

	public Localidad getInteger() {
		return Integer;
	}

	public void setInteger(Localidad integer) {
		Integer = integer;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
