package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil_usuario")

public class PerfilUsuario {

	
	@Id
	@Column(name = "id_perfil")
	private int idPerfil;
	
	@Column(name = "nombre_perfil")
	private String nombrePerfil;
	
	
}
