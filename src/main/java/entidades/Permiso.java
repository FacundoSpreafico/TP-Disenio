package entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "permiso")

public class Permiso {

	@Id
	@Column(name = "id_permiso")
	private int idPermiso;
	
	@Column (name = "operacion_permitida")
	private String operacionPermitida;
	
	@OneToMany(mappedBy = "perfil_usuario")
	private List<PerfilUsuario> perfilesPermitidos = new ArrayList <>();
	
	
}
