package entidades;

import java.util.Date;

import org.hibernate.annotations.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cliente")

public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	private String nroDocumento;
	
	@Column(name = "estado_cliente")
	private String estadoCliente;
	
	/*
	Domicilio domicilio;
	*/
	
	public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNroCuil() {
		return nroCuil;
	}

	public void setNroCuil(String nroCuil) {
		this.nroCuil = nroCuil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCondicionIVA() {
		return condicionIVA;
	}

	public void setCondicionIVA(String condicionIVA) {
		this.condicionIVA = condicionIVA;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getAnioRegistro() {
		return anioRegistro;
	}

	public void setAnioRegistro(Integer anioRegistro) {
		this.anioRegistro = anioRegistro;
	}

	public String getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
	
	
}
