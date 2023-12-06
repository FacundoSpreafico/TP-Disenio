package DAO;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entidades.Cliente;
import entidades.HistorialEstadisticaRobo;
import entidades.Marca;
import entidades.Modelo;
import entidades.PerfilUsuario;
import entidades.Usuario;

public class ModeloDAOImp implements ModeloDAO {
	@Override
	public List<Modelo> recuperarModelosPorMarca(Marca marca) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            try {
                String hql = "FROM Modelo WHERE marca = :idMarca";
                Query<Modelo> query = session.createQuery(hql,Modelo.class);
                query.setParameter("idMarca", marca);
                List<Modelo> marcas = query.getResultList();
                session.close();
                return marcas;
            } catch (Exception e) {
            }
        }
        return Collections.emptyList();
	}

	public Modelo recuperarModeloPorNombre(String nombre) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            try {
                String hql = "FROM Modelo WHERE nombreModelo = :nombre";
                Query<Modelo> query = session.createQuery(hql,Modelo.class);
                query.setParameter("nombre", nombre);
                Modelo modelo = query.getSingleResult();
                session.close();
                return modelo;
            } catch (Exception e) {
            }
        }
		return null;
	}

	@Override
	public Modelo obtenerModelo(String nombreMarca, String nombreModelo) {
		
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
		String hql = "FROM Modelo mo JOIN mo.marca ma WHERE ma.nombreMarca = :nombreMarcaDTO AND mo.nombreModelo = :nombreModeloDTO";
		Query<Modelo> query = session.createQuery(hql,Modelo.class);
		query.setParameter("nombreMarcaDTO", nombreMarca);
		query.setParameter("nombreModeloDTO", nombreModelo);
		Modelo modelo = query.getSingleResult();
		session.close();
		return modelo;
		}
	
	}

	
	
}
