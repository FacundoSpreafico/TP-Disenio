package DAO;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entidades.Cobertura;
import entidades.HistorialPorcentajeCobertura;
import entidades.PerfilUsuario;
import entidades.Usuario;

public class CoberturaDAOImp implements CoberturaDAO{
	public List<Cobertura> recuperarCoberturas(){
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            try {
                String hql = "FROM Cobertura";
                Query<Cobertura> query = session.createQuery(hql,Cobertura.class);
                List<Cobertura> coberturas = query.getResultList();
                session.close();
                return coberturas;
            } catch (Exception e) {
            }
        }
        return Collections.emptyList();
	}

	public Cobertura buscarPorNombre(String nombreCobertura) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
           String hql = "FROM Cobertura WHERE nombreCobertura = :nombreCobertura";
           Query<Cobertura> query = session.createQuery(hql,Cobertura.class);
           query.setParameter("nombreCobertura",nombreCobertura);
           Cobertura cobertura = query.getSingleResult();
           session.close();
           return cobertura;
        }
	}
	
}
