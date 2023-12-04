package DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import entidades.MedidaDeSeguridad;

public class MedidaDeSeguridadDAOImp implements MedidaDeSeguridadDAO{

	@Override
	public MedidaDeSeguridad obtenerPorNombre(String nombreMedida) {
		try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()){
			 String hql = "FROM MedidaDeSeguridad m WHERE m.nombreMedida = :nombreMedida";
			 Query<MedidaDeSeguridad> query = session.createQuery(hql, MedidaDeSeguridad.class);
			 query.setParameter("nombreMedida", nombreMedida);
			 MedidaDeSeguridad medida = query.getSingleResult();
			 session.close(); 
			 return medida;
		 }
	}

	
	
}
