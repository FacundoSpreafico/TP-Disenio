package DAO;

import DTO.ModeloDTO;
import entidades.Modelo;
import entidades.SumaAsegurada;

public interface SumaAseguradaDAO {

	public SumaAsegurada devolverSumaAsegurada(ModeloDTO modelo);

}