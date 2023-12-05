package gestores;

import java.util.List;

import DAO.CoberturaDAOImp;
import entidades.Cobertura;

public class GestorCobertura {
	private static GestorCobertura _INSTANCE;
	private CoberturaDAOImp coberturaDAO = new CoberturaDAOImp();
	
	public static GestorCobertura getInstance() {
		if (_INSTANCE == null) {
			_INSTANCE = new GestorCobertura();
		}
		return _INSTANCE;
	}
	
	public List<Cobertura> recuperarCoberturas(){
		return coberturaDAO.recuperarCoberturas();
	}
	
	public Cobertura buscarCobertura(String nombreCobertura) {
		return coberturaDAO.buscarPorNombre(nombreCobertura);
	}
	
	
	
}
