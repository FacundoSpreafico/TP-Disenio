package DAO;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entidades.Cliente;
import entidades.Localidad;
import entidades.Marca;
import entidades.Pais;
import entidades.Provincia;

public class LocalidadDAOImp implements LocalidadDAO {
	public List<Pais> obtenerPaises(){
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Pais.class).addAnnotatedClass(Provincia.class).addAnnotatedClass(Localidad.class).buildSessionFactory();
		
		try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                String hql = "FROM Pais";
                Query<Pais> query = session.createQuery(hql, Pais.class);
                List<Pais> paises  = query.getResultList();

                transaction.commit();
                return paises;
                
                
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
		return Collections.emptyList();
	}
	public List<Provincia> obtenerProvincias(Pais pais){
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Pais.class).addAnnotatedClass(Provincia.class).addAnnotatedClass(Localidad.class).buildSessionFactory();
		
		try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
            	String hql = "FROM Provincia WHERE pais = :pais";
                Query<Provincia> query = session.createQuery(hql, Provincia.class);
                query.setParameter("pais", pais);
                List<Provincia> provincias = query.getResultList();

                transaction.commit();
                return provincias;
                
                
                
                
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
		return Collections.emptyList();
	}
	public List<Localidad> obtenerLocalidades(Provincia provincia){
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml").addAnnotatedClass(Pais.class).addAnnotatedClass(Provincia.class).addAnnotatedClass(Localidad.class).buildSessionFactory();
		
		try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                String hql = "FROM Localidad WHERE provincia = :provincia";
                Query<Localidad> query = session.createQuery(hql, Localidad.class);
                query.setParameter("provincia",provincia);
                List<Localidad> localidades  = query.getResultList();

                transaction.commit();
                return localidades;
                
                
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
		return Collections.emptyList();
	}
}
