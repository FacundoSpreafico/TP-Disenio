package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

    @Embeddable 
	class DeclaraMedidaID implements Serializable{
		@Column(name = "id_poliza")
		private int idPoliza;
		@Column(name = "id_medida")
		private int idMedida;
		
		public int getIdPoliza() {
			return idPoliza;
		}
		public void setIdPoliza(int idPoliza) {
			this.idPoliza = idPoliza;
		}
		public int getIdMedida() {
			return idMedida;
		}
		public void setIdMedida(int idMedida) {
			this.idMedida = idMedida;
		}
	}
	
@Entity
@Table (name = "declara_medida")
public class DeclaraMedida {
	@EmbeddedId
	DeclaraMedidaID id;

    @ManyToOne
    @JoinColumn(name = "id_poliza")
    private Poliza poliza;
	
    @ManyToOne
    @JoinColumn(name = "id_medida")
    private MedidaDeSeguridad medida;
}


