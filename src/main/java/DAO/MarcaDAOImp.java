package DAO;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entidades.HistorialEstadisticaRobo;
import entidades.Marca;
import entidades.Modelo;
import entidades.PerfilUsuario;
import entidades.Usuario;


public class MarcaDAOImp implements MarcaDAO{
	@Override
	public List<Marca> recuperarMarcas() {
        try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            try {
                String hql = "FROM Marca ORDER BY nombreMarca";
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
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
            try {
                String hql = "FROM Marca WHERE nombreMarca = :nombre";
                Query<Marca> query = session.createQuery(hql,Marca.class);
                query.setParameter("nombre", nombre);
                Marca marca = query.getSingleResult();
                session.close();
                return marca;
            } catch (Exception e) {
            }
        }
		return null;
	}
	
	
	
	
}
