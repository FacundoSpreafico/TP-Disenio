package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaRoot;
import org.hibernate.cfg.Configuration;

import DTO.ClienteDTO;
import entidades.Cliente;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ClienteDAOImp implements ClienteDAO {
    private static final SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();

    @Override
    public List<Cliente> buscarClientes(ClienteDTO clienteDTO) {
        try (Session session = sessionFactory.openSession()) {
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
        int tamañoLista = 5; 
        Predicate[] restricciones = new Predicate[tamañoLista];
        int índice = 0;
        
        if (clienteDTO.getNroCliente() != null) {
            restricciones[índice++] = criteriaBuilder.equal(root.get("nroCliente"), clienteDTO.getNroCliente());
        }
        if (clienteDTO.getNombre() != null) {
            restricciones[índice++] = criteriaBuilder.equal(root.get("nombre"), clienteDTO.getNombre());
        }
        if (clienteDTO.getApellido() != null) {
            restricciones[índice++] = criteriaBuilder.equal(root.get("apellido"), clienteDTO.getApellido());
        }
        if (clienteDTO.getTipoDocumento() != null) {
            restricciones[índice++] = criteriaBuilder.equal(root.get("tipoDocumento"), clienteDTO.getTipoDocumento());
        }
        if (clienteDTO.getNroDocumento() != null) {
            restricciones[índice] = criteriaBuilder.equal(root.get("nroDocumento"), clienteDTO.getNroDocumento());
        }
        if (índice == tamañoLista) {
        	return restricciones;  
        	
        	
        	
        }
        else {
        	return java.util.Arrays.copyOf(restricciones, índice);
        }
    }
    }





