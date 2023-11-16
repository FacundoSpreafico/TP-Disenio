package entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")

public class Cliente {
	@Id
	@Column(name = "id_cliente")
	private Integer idCliente;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "sexo")
	private String sexo;

	@Column(name = "nro_cliente")
	private String nroCliente;

	@Column(name = "tipo_documento")
	private String tipoDocumento;

	@Column(name = "nro_cuil")
	private String nroCuil;

	@Column(name = "estado_civil")
	private String estadoCivil;

	@Column(name = "profesion")
	private String profesion;

	@Column(name = "email")
	private String email;

	@Column(name = "condicion_iva")
	private String condicionIVA;

	@Column(name = "tipo_cliente")
	private String tipoCliente;

	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name = "anioregistro")
	private Integer anioRegistro;

	@Column(name = "nro_documento")
	private long nroDocumento;
	
	@Column(name = "estado_cliente")
	private String estadoCliente;
	
	/*
	Domicilio domicilio;
	*/
	
}
