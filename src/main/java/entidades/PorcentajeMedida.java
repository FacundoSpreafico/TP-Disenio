package entidades;

import java.io.Serializable;

import org.hibernate.annotations.ForeignKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


    @Embeddable
	class PorcentajeMedidaID implements Serializable{
		@Column(name = "id_poliza")
		Poliza poliza;
		
		@Column(name = "id_historial_porcentaje_medida")
		HistorialPorcentajeMedida historial;	
	}
	
    @Entity
    @Table(name = "porcentaje_medida")
    public class PorcentajeMedida {

    @EmbeddedId
    private PorcentajeMedidaID id;
	
    @ManyToOne
    @JoinColumn(name = "id_poliza")
    private Poliza poliza;

    @ManyToOne
    @JoinColumn(name = "id_historial_porcentaje_medida")
    private HistorialPorcentajeMedida historial;
    
    }
	
	

