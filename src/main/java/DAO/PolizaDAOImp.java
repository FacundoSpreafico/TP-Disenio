package DAO;

import org.hibernate.Session;

import entidades.Poliza;
import jakarta.persistence.CascadeType;
import org.hibernate.Transaction;

public class PolizaDAOImp implements PolizaDAO{

	@Override
	public void insertarPoliza(Poliza poliza) {
	    try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        session.save(poliza);
	        System.out.print("Save");
	        transaction.commit();
	    } catch (Exception e) {
	        // Manejo de excepciones (puedes realizar un rollback aquí si es necesario)
	        e.printStackTrace();
	    }
	}


	
}
