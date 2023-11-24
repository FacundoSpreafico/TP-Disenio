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


public class MarcaDAOImp implements MarcaDAO{
	public static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Marca.class).buildSessionFactory();
	@Override
	public List<Marca> recuperarMarcas() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                String hql = "FROM Marca";
                Query<Marca> query = session.createQuery(hql,Marca.class);
                List<Marca> marcas = query.getResultList();

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
