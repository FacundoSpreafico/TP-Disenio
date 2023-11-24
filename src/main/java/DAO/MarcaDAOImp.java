package DAO;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entidades.Cliente;
import entidades.Marca;
import entidades.Modelo;


public class MarcaDAOImp implements MarcaDAO{
	public static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Marca.class).buildSessionFactory();
	@Override
	public List<Marca> recuperarMarcas() {
        try (Session session = sessionFactory.openSession()) {
            try {
                String hql = "FROM Marca";
                Query<Marca> query = session.createQuery(hql,Marca.class);
                List<Marca> marcas = query.getResultList();
                session.close();
                return marcas;
            } catch (Exception e) {
            }
        }
        return Collections.emptyList();
       
    }
	@Override
	public Marca recuperarMarcaPorNombre(String nombre) {
		try (Session session = sessionFactory.openSession()) {
            try {
                String hql = "FROM Marca WHERE nombreMarca = :nombre";
                Query<Marca> query = session.createQuery(hql,Marca.class);
                query.setParameter("nombre", nombre);
                return query.getSingleResult();
            } catch (Exception e) {
            }
        }
		return null;
	}
	
	
	
	
}
