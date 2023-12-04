package entidades;

import java.util.Date;
import java.util.Objects;

import com.toedter.calendar.JDateChooser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hijo_cliente")

public class HijoCliente {

	@Id
	@Column(name = "id_hijo_cliente")
	private int idHijoCliente;
	@Column(name = "sexo")
	private String sexo;
	@Column(name = "estado_civil")
	private String estadoCivil;
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	
	public HijoCliente() {
	    // Constructor sin parámetros
	}

	public HijoCliente (Date fechaNacimiento, String sexo, String estadoCivil) {
		this.fechaNacimiento = fechaNacimiento;
		this.sexo= sexo;
		this.estadoCivil = estadoCivil;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public int hashCode() {
		return Objects.hash(estadoCivil, fechaNacimiento, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HijoCliente other = (HijoCliente) obj;
		return Objects.equals(estadoCivil, other.estadoCivil) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
		&& Objects.equals(sexo, other.sexo);
	}

	public int getIdHijoCliente() {
		return idHijoCliente;
	}

	public void setIdHijoCliente(int idHijoCliente) {
		this.idHijoCliente = idHijoCliente;
	}
	
	
}
