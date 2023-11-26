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

public class ModeloDAOImp implements ModeloDAO {
	 private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Modelo.class).addAnnotatedClass(Marca.class).buildSessionFactory();
	@Override
	public List<Modelo> recuperarModelosPorMarca(Marca marca) {
		try (Session session = sessionFactory.openSession()) {
            try {
                String hql = "FROM Modelo WHERE marca = :idMarca";
                Query<Modelo> query = session.createQuery(hql,Modelo.class);
                query.setParameter("idMarca", marca);
                List<Modelo> marcas = query.getResultList();
                return marcas;
            } catch (Exception e) {
            }
        }
        return Collections.emptyList();
	}
	
	public Modelo recuperarModeloPorNombre(String nombre) {
		try (Session session = sessionFactory.openSession()) {
            try {
                String hql = "FROM Modelo WHERE nombreModelo = :nombre";
                Query<Modelo> query = session.createQuery(hql,Modelo.class);
                query.setParameter("nombre", nombre);
                return query.getSingleResult();
            } catch (Exception e) {
            }
        }
		return null;
	}
	
	
}
