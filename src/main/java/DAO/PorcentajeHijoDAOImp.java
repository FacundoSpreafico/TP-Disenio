package DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entidades.HistorialPorcentajeHijo;
import entidades.PorcentajePorHijo;

public class PorcentajeHijoDAOImp implements PorcentajeHijoDAO{
	public HistorialPorcentajeHijo getPorcentajeActual(int cantHijos) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
		String hql = "FROM PorcentajePorHijo WHERE cantidadHijos = :cantHijos";
		Query<PorcentajePorHijo> query = session.createQuery(hql,PorcentajePorHijo.class);
		query.setParameter("cantHijos", cantHijos);
		PorcentajePorHijo porcentaje = query.getSingleResult();
		return porcentaje.getValorActual();	
		}
	}
}
