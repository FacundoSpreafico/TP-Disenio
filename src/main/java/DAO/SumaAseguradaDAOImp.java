package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import DTO.ModeloDTO;
import entidades.HistorialEstadisticaRobo;
import entidades.Marca;
import entidades.Modelo;
import entidades.PerfilUsuario;
import entidades.SumaAsegurada;
import entidades.Usuario;

public class SumaAseguradaDAOImp implements SumaAseguradaDAO{
	
	public SumaAsegurada devolverSumaAsegurada(String nombreModelo, int anioFabricacion) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()){
    	 try {
             String hql = "FROM SumaAsegurada WHERE modelo.nombreModelo = :nombreModelo AND anioFabricacion = :anio";
             Query<SumaAsegurada> query = session.createQuery(hql,SumaAsegurada.class);
             query.setParameter("nombreModelo",nombreModelo);
             query.setParameter("anio", anioFabricacion);
             
             
             return query.getSingleResult();
         } catch (Exception e) {
        	 
         }
    }
	return null;
	}

	
	
}