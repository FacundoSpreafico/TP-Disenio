package DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entidades.HistorialPorcentajeKM;
import entidades.PorcentajePorKms;

public class PorcentajePorKmsDAOImp implements PorcentajePorKmsDAO{
	public HistorialPorcentajeKM getPorcentajeActual(String cantKmsPorAnio) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
		String hql = "FROM PorcentajePorKms pkms WHERE rangoKms = :cantKmsPorAnio";
		Query<PorcentajePorKms> query = session.createQuery(hql,PorcentajePorKms.class);
		query.setParameter("cantKmsPorAnio", cantKmsPorAnio);
		PorcentajePorKms porcentaje = query.getSingleResult();
		session.close();
		return porcentaje.getValorActual();	
		}
	}
}
