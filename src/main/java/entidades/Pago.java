package entidades;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
}
