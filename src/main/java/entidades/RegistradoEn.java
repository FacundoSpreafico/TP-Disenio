package entidades;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Embeddable 
class RegistradoENID implements Serializable{
    @Column(name = "id_hijo_ciente")
    int idHijoCliente;
    @Column(name = "id_poliza")
    int idPoliza;
}

@Entity
@Table(name = "registrado_en")
public class RegistradoEn {

    @OneToMany
    @MapsId("id_hijo_cliente")
    @PrimaryKeyJoinColumn
    private HijoCliente hijoCliente;

    @OneToMany
    @MapsId("id_poliza")
    @PrimaryKeyJoinColumn
    private Poliza poliza;


}