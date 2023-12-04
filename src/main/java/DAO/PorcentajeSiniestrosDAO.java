package DAO;

import entidades.HistorialPorcentajeSiniestros;

public interface PorcentajeSiniestrosDAO {
	public HistorialPorcentajeSiniestros getPorcentajeActual(String cantSiniestros);
}
