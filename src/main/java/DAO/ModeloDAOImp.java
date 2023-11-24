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
	public List<Modelo> recuperarModelosPorMarca() {
		try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                String hql = "FROM Modelo";
                Query<Modelo> query = session.createQuery(hql,Modelo.class);
                List<Modelo> marcas = query.getResultList();

                transaction.commit();
                return marcas;
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace(); //
            }
        }
        return Collections.emptyList();
	}

	
	
	
}
