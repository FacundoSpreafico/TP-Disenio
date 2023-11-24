package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import DTO.ModeloDTO;
import entidades.Marca;
import entidades.Modelo;
import entidades.SumaAsegurada;

public class SumaAseguradaDAOImp implements SumaAseguradaDAO{
	private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(SumaAsegurada.class)
			.addAnnotatedClass(Marca.class)
			.addAnnotatedClass(Modelo.class)
			.buildSessionFactory();
	@Override
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