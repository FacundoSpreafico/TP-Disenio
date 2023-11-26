package DAO;

import java.util.List;

import entidades.Marca;

public interface MarcaDAO {

	public List<Marca> recuperarMarcas();
	public Marca recuperarMarcaPorNombre(String nombre);
}
