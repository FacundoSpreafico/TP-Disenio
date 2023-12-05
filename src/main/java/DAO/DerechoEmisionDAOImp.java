package DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entidades.HistorialDerechoEmision;

public class DerechoEmisionDAOImp implements DerechoEmisionDAO {
	public HistorialDerechoEmision getHistorialActual() {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
			String hql = "FROM HistorialDerechoEmision WHERE hasta = null";
			Query<HistorialDerechoEmision> query = session.createQuery(hql,HistorialDerechoEmision.class);
			HistorialDerechoEmision historial = query.getSingleResult();
			return historial;	
			}
	}
}
