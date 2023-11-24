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
	public static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(Cobertura.class)
			.addAnnotatedClass(HistorialPorcentajeCobertura.class)
			.addAnnotatedClass(Usuario.class)
			.addAnnotatedClass(PerfilUsuario.class)
			.buildSessionFactory();
	
	public List<Cobertura> recuperarCoberturas(){
		try (Session session = sessionFactory.openSession()) {
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
	
}
