package DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entidades.Poliza;
import entidades.Premio;

public class PolizaDAOImp implements PolizaDAO{
	ClienteDAO clienteDAO = new ClienteDAOImp();
	@Override
	
	public void insertarPoliza(Poliza poliza) {
	    Transaction transaction = null;
	    try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
	        transaction = session.beginTransaction();
	        session.save(poliza);
	        clienteDAO.actualizarEstadoCliente(poliza.getCliente(), poliza);
	        transaction.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


	
}
