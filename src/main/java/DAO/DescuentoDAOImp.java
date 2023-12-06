package DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entidades.DescuentoPorUnidadAdicional;
import entidades.HistorialDescuentoPorUnidadAdicional;

public class DescuentoDAOImp implements DescuentoDAO {
	public HistorialDescuentoPorUnidadAdicional getPorcentajeActual(String cantUnidades) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
			String hql = "FROM DescuentoPorUnidadAdicional WHERE cantUnidades = :cantUnidades";
			Query<DescuentoPorUnidadAdicional> query = session.createQuery(hql,DescuentoPorUnidadAdicional.class);
			query.setParameter("cantUnidades", cantUnidades);
			DescuentoPorUnidadAdicional porcentaje = query.getSingleResult();
			return porcentaje.getValorActual();	
			}
	}

}
