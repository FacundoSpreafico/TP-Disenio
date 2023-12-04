package DAO;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionCreationOptions;

import DTO.ClienteDTO;
import entidades.Cliente;
import entidades.Marca;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ClienteDAOImp implements ClienteDAO {
    
    public void create(Cliente cliente) {
		Session session = SessionHibernate.getInstance().getSessionFactory().openSession();
    	try {
        session.beginTransaction();
	    session.save(cliente);
	    session.getTransaction().commit();
	    session.close();  
    	}
    	catch(Exception e) {
    	}
	}
    
    public List<Cliente> buscarClientes(ClienteDTO clienteDTO) {
        try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
        	
        	CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Cliente> criteriaQuery = criteriaBuilder.createQuery(Cliente.class);
            Root<Cliente> root = criteriaQuery.from(Cliente.class);

            Predicate[] restricciones = construirRestricciones(criteriaBuilder, root, clienteDTO);
            
            criteriaQuery.where(restricciones);
            
            Query<Cliente> query = session.createQuery(criteriaQuery);
           
            return query.getResultList();
        }
    }

    
    private Predicate[] construirRestricciones(CriteriaBuilder criteriaBuilder, Root<Cliente> root, ClienteDTO clienteDTO) {
        int tamañoLista = 100;
        Predicate[] restricciones = new Predicate[tamañoLista];
        int indice = 0;

        if (clienteDTO.getNroCliente() != null) {
            restricciones[indice++] = criteriaBuilder.like(root.get("nroCliente"),clienteDTO.getNroCliente() + "%");
        }
        if (clienteDTO.getNombre() != null) {
        	 restricciones[indice++] = criteriaBuilder.like(criteriaBuilder.upper(root.get("nombre")),clienteDTO.getNombre().toUpperCase() + "%");
        }
        if (clienteDTO.getApellido() != null) {
            restricciones[indice++] = criteriaBuilder.like(criteriaBuilder.upper(root.get("apellido")),clienteDTO.getApellido().toUpperCase() + "%");
        }
        if (clienteDTO.getTipoDocumento() != null) {
            restricciones[indice++] = criteriaBuilder.equal(root.get("tipoDocumento"), clienteDTO.getTipoDocumento());
        }
        if (clienteDTO.getNroDocumento() != null) {
            restricciones[indice++] = criteriaBuilder.like(root.get("nroDocumento"),clienteDTO.getNroDocumento() + "%");
        }

        if (indice == tamañoLista) {
            return restricciones;
        } else {
            return Arrays.copyOf(restricciones, indice);
        }
    }
    
    public int recuperarID(String nroCliente) {
    	try(Session session = SessionHibernate.getInstance().getSessionFactory().openSession()){
    		try {
                String hql = "SELECT idCliente FROM Cliente WHERE nroCliente = :nro";
                Query<Integer> query = session.createQuery(hql,Integer.class);
                query.setParameter("nro",nroCliente);
                return query.getSingleResult();
            } catch (Exception e) {
            }
    	}
		return 0;
    }
    
    
    
}
	





