package DAO;

import java.util.List;

import entidades.Marca;
import entidades.Modelo;

public interface ModeloDAO {
	
	List<Modelo> recuperarModelosPorMarca(Marca marca);
	
	
}
