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
	private char departamento;
	
	@Column(name = "codigo_postal")
	private Integer codigo_postal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_localidad")
	private Localidad Integer;
	
	@OneToOne
	@MapsId
	@PrimaryKeyJoinColumn
	private Cliente cliente;
	
	
	
}
