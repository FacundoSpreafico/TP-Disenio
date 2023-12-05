package DAO;

import java.util.List;

import entidades.Cobertura;

public interface CoberturaDAO {
	
	public List<Cobertura> recuperarCoberturas();
	public Cobertura buscarPorNombre(String nombreCobertura);
}
