package DAO;

import entidades.HistorialPorcentajeKM;

public interface PorcentajePorKmsDAO {
	public HistorialPorcentajeKM getPorcentajeActual(String cantKmsPorAnio);
}
