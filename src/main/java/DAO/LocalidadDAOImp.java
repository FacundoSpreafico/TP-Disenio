package DAO;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entidades.HistorialPorcentajeRiesgo;
import entidades.Localidad;
import entidades.Pais;
import entidades.PerfilUsuario;
import entidades.Provincia;
import entidades.Usuario;

public class LocalidadDAOImp implements LocalidadDAO {	
	public List<Pais> obtenerPaises(){
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            //Transaction transaction = session.beginTransaction();

            try {
                String hql = "FROM Pais";
                Query<Pais> query = session.createQuery(hql, Pais.class);
                List<Pais> paises  = query.getResultList();

                //transaction.commit();
                session.close();
                return paises;
                
                
            } catch (Exception e) {
                /*if (transaction != null) {
                    transaction.rollback();
                }*/
                e.printStackTrace();
            }
        }
		return Collections.emptyList();
	}
	
	public Pais recuperarPaisPorNombre(String nombre) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            try {
                String hql = "FROM Pais WHERE nombrePais = :nombre";
                Query<Pais> query = session.createQuery(hql,Pais.class);
                query.setParameter("nombre", nombre);
                Pais pais = query.getSingleResult();
                session.close();
                return pais;
            } catch (Exception e) {
            }
        }
		return null;
	}
	
	public Provincia recuperarProvinciaPorNombre(String nombre) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            try {
                String hql = "FROM Provincia WHERE nombreProvincia = :nombre";
                Query<Provincia> query = session.createQuery(hql,Provincia.class);
                query.setParameter("nombre", nombre);
                Provincia provincia = query.getSingleResult();
                session.close();
                return provincia;
            } catch (Exception e) {
            }
        }
		return null;
	}
	
	
	public List<Provincia> obtenerProvincias(Pais pais){
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
            	String hql = "FROM Provincia WHERE pais = :pais";
                Query<Provincia> query = session.createQuery(hql, Provincia.class);
                query.setParameter("pais", pais);
                List<Provincia> provincias = query.getResultList();
                pais.setProvincias(provincias);  
                transaction.commit();
                session.close();
                return provincias;   
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
            session.close();
        }
		return Collections.emptyList();
	}
	public List<Localidad> obtenerLocalidades(Provincia provincia){
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                String hql = "FROM Localidad WHERE provincia = :provincia";
                Query<Localidad> query = session.createQuery(hql, Localidad.class);
                query.setParameter("provincia",provincia);
                List<Localidad> localidades  = query.getResultList();

                transaction.commit();
                session.close();
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

	@Override
	public Localidad obtenerLocalidad(String localidad, String provincia, String pais) {
		 
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
		String hql = "FROM Localidad l " +
                "JOIN l.provincia p " +
                "JOIN p.pais pa " +
                "WHERE l.nombreLocalidad = :nombreLocalidad " +
                "AND p.nombreProvincia = :nombreProvincia " +
                "AND pa.nombrePais = :nombrePais";
        
		Query<Localidad> query = session.createQuery(hql,Localidad.class);
		query.setParameter("nombreLocalidad", localidad);
        query.setParameter("nombreProvincia", provincia);
        query.setParameter("nombrePais", pais);
        Localidad localidadBuscada = query.getSingleResult();
        session.close();
        return localidadBuscada;
		}
	}
	
	
}
