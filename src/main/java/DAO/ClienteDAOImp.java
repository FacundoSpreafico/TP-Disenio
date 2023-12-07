package DAO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import DTO.ClienteDTO;
import entidades.Cliente;
import entidades.Poliza;
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
            List<Cliente> listaClientes = query.getResultList();
            session.close();
            return listaClientes;
        }
    }
    
    public List<Cliente> buscarClientes() {
        try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()) {
        	String hql = "FROM Cliente ORDER BY apellido, nombre";
            Query<Cliente> query = session.createQuery(hql,Cliente.class);
            List<Cliente> listaClientes = query.getResultList();
            session.close();
            return listaClientes;
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
    
    public Cliente obtenerPorId(int idCliente) {
    	try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()){
    	Cliente cliente = session.get(Cliente.class,idCliente);
    	session.close();
    	return cliente;
    	}
    	
    }

    public Long obtenerCantidadVehiculos(int idCliente) {
        try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()){
            String hql = "SELECT COUNT(DISTINCT v.idVehiculo) FROM Cliente c, Poliza p, Vehiculo v"
            		+ " WHERE c.idCliente = :idCliente AND c = p.cliente AND p.vehiculo = v";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("idCliente", idCliente);
            
            Long result = query.getSingleResult();
            session.close();
            return result;
        }
    }
    
    public Long obtenerCantidadPolizasAsociadas(Cliente cliente) {
    	try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()){
   		 //Busca las polizas vigentes actuales luego de generar la poliza
            String hql = "SELECT COUNT(DISTINCT p.idPoliza) FROM Poliza p, Cliente c "
            		   + "WHERE c.idCliente = :idCliente AND c = p.cliente";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("idCliente", cliente.getIdCliente());
            
            Long result = query.getSingleResult();
            session.close();
            return result;
    	}
    }
    
    public Long obtenerCantidadCuotasImpagas(Cliente cliente) {
    	try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()){
            
            String hql2 = "SELECT COUNT(DISTINCT cu.idCuota) FROM Poliza p, Cliente cl, Cuota cu "
             		    + "WHERE cl.idCliente = :idCliente AND cl = p.cliente "
             		    + "AND p.fechaFin > :fechaActual "
             		    + "AND cu.poliza = p AND cu.estado = 'impaga' AND cu.fechaVencimiento < :fechaActual";
            
            Query<Long> queryCuotas = session.createQuery(hql2, Long.class);
            queryCuotas.setParameter("idCliente", cliente.getIdCliente());
            Date fechaActual = new Date();
            queryCuotas.setParameter("fechaActual", fechaActual);
            
            Long result = queryCuotas.getSingleResult();
            session.close();
            return result;
    	}
    }
    
    public List<Poliza> devolverPolizasVigentes(Cliente cliente){
    	try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()){    
            String hql3 = "SELECT p FROM Poliza p, Cliente c "
             		    + "WHERE c.idCliente = :idCliente AND c = p.cliente "
             		    + "AND p.fechaFin > :fechaActual";
             
             Query<Poliza> queryPolizas = session.createQuery(hql3, Poliza.class);
             queryPolizas.setParameter("idCliente", cliente.getIdCliente());
             Date fechaActual = new Date();
             queryPolizas.setParameter("fechaActual", fechaActual);
             
             List<Poliza> result = queryPolizas.getResultList();
             session.close();
             return result;
            
    	}
    }
    
    public void actualizarEstadoCliente(Cliente cliente, Poliza poliza) { 
    	 Transaction transaction = null;
    	 try (Session session = SessionHibernate.getInstance().getSessionFactory().openSession()){
    		 transaction = session.beginTransaction();
             Long cantidadPolizasAsociadas = obtenerCantidadPolizasAsociadas(cliente);
             Long cantidadCuotasImpagas = obtenerCantidadCuotasImpagas(cliente);
             List<Poliza> listaPolizasVigentes = devolverPolizasVigentes(cliente);
             
             //Si se verifica que la poliza se creo en una 4ta renovacion consecutiva entonces
             //habrán pasado 2 años de manera ininterrumpida en el que el cliente ha estado activo.
             //Su condición cambia a "Plata"
             
              boolean tieneAntiguedad2Anios = false;
              for(Poliza p : listaPolizasVigentes) {
            	  String substring = p.getNumeroPoliza().substring(11);
            	  int ultimosDigitos = Integer.parseInt(substring);

            	  if(ultimosDigitos >= 05) {
            		  tieneAntiguedad2Anios = true;
            	  }
              }
             
             
             if(cantidadPolizasAsociadas >= 1) {
            	 cliente.setTipoCliente("Normal");
            	 if(listaPolizasVigentes.size() > 0) {
            		 cliente.setEstadoCliente("Activo");
            	 }
            	 
            	 if(poliza.getNroSiniestros().equals("Ninguno") && cantidadCuotasImpagas == 0 && tieneAntiguedad2Anios) {
            		 cliente.setTipoCliente("Plata");
            	 }
            	
            	 session.update(cliente);
            	 transaction.commit();
            	 session.close();
             }
    	 }
    }
}
	





