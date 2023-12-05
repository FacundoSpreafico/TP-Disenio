package DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entidades.HistorialPorcentajeSiniestros;
import entidades.PorcentajePorSiniestros;

public class PorcentajeSiniestrosDAOImp implements PorcentajeSiniestrosDAO {
	public HistorialPorcentajeSiniestros getPorcentajeActual(String cantSiniestros) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
		String hql = "FROM PorcentajePorSiniestros WHERE cantidadSiniestros = :cantSiniestros";
		Query<PorcentajePorSiniestros> query = session.createQuery(hql,PorcentajePorSiniestros.class);
		query.setParameter("cantSiniestros", cantSiniestros);
		PorcentajePorSiniestros porcentaje = query.getSingleResult();
		return porcentaje.getValorActual();	
		}
	}
}
