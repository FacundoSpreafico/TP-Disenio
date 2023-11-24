package DAO;

import java.util.List;

import entidades.Marca;
import entidades.Modelo;

public interface ModeloDAO {
	public List<Modelo> recuperarModelosPorMarca(Marca marca);
	public Modelo recuperarModeloPorNombre(String modelo);
	
}
