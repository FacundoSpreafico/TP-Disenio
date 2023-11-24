package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "premio")
public class Premio {
	
	
	@Id
	private Integer idPoliza;
	
	@Column(name = "prima")
	private Float prima;
	
	@Column(name = "derechos_emision")
	private Float derechos_emision;
	
	@Column(name = "total")
	private Float total;
	
	@OneToOne
	@MapsId
	@PrimaryKeyJoinColumn
	private Poliza poliza;
}
