package entidades;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "historial_porcentaje_hijo")
public class HistorialPorcentajeHijo {


	@Id
	@Column(name = "id_historial_porcentaje_hijo")
	private int idHistorialPorcentajeHijo;
	
	@Column(name = "desde")
	private Date fechaDesde;
	@Column(name = "hasta")
	private Date fechaHasta;
	@Column(name = "valor_porcentual")
	private double valorPorcentual;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_porcentaje_hijo")
	private PorcentajePorHijo porcentaje;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario")
	private Usuario operador;
}
