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
	private double prima;
	
	@Column(name = "derechos_emision")
	private double derechos_emision;
	
	@Column(name = "total")
	private double total;
	
	@OneToOne
	@MapsId
	@PrimaryKeyJoinColumn
	private Poliza poliza;

	public Integer getIdPoliza() {
		return idPoliza;
	}

	public void setIdPoliza(Integer idPoliza) {
		this.idPoliza = idPoliza;
	}

	public double getPrima() {
		return prima;
	}

	public void setPrima(double prima) {
		this.prima = prima;
	}

	public double getDerechos_emision() {
		return derechos_emision;
	}

	public void setDerechos_emision(double derechos_emision) {
		this.derechos_emision = derechos_emision;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Poliza getPoliza() {
		return poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}
	
	
}
