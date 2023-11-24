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
	private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(SumaAsegurada.class)
			.addAnnotatedClass(Marca.class)
			.addAnnotatedClass(Modelo.class)
			.addAnnotatedClass(HistorialEstadisticaRobo.class)
			.addAnnotatedClass(Usuario.class)
			.addAnnotatedClass(PerfilUsuario.class)
			.buildSessionFactory();
	public SumaAsegurada devolverSumaAsegurada(ModeloDTO modelo) {
	    
		try (Session session = sessionFactory.openSession()){
    	 try {
             String hql = "FROM SumaAsegurada WHERE modelo.idModelo = :idModelo AND anioFabricacion = :anio";
             Query<SumaAsegurada> query = session.createQuery(hql,SumaAsegurada.class);
             query.setParameter("idModelo",modelo.getIdModelo());
             query.setParameter("anio",modelo.getAnioFabricacion());
             return query.getSingleResult();
         } catch (Exception e) {
        	 
         }
    }
	return null;
	}
	
	
}