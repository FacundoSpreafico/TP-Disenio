package DAO;

import java.util.List;

import entidades.Localidad;
import entidades.Pais;
import entidades.Provincia;

public interface LocalidadDAO {
	public List<Pais> obtenerPaises();
	public List<Provincia> obtenerProvincias(Pais pais);
	public List<Localidad> obtenerLocalidades(Provincia provincia);
	public Pais recuperarPaisPorNombre(String nombre);
	public Provincia recuperarProvinciaPorNombre(String nombre);
	public Localidad obtenerLocalidad(String localidad, String provincia, String pais);
	
	
}
