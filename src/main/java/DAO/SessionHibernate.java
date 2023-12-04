package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entidades.Cliente;
import entidades.Cobertura;
import entidades.HistorialEstadisticaRobo;
import entidades.HistorialPorcentajeCobertura;
import entidades.HistorialPorcentajeMedida;
import entidades.HistorialPorcentajeRiesgo;
import entidades.Localidad;
import entidades.Marca;
import entidades.MedidaDeSeguridad;
import entidades.Modelo;
import entidades.Pais;
import entidades.PerfilUsuario;
import entidades.Provincia;
import entidades.SumaAsegurada;
import entidades.Usuario;

public class SessionHibernate {

    private static SessionHibernate _INSTANCE;
    private static final SessionFactory sessionFactory;

    private SessionHibernate() {
    }

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
            		.addAnnotatedClass(Cliente.class)
            		.addAnnotatedClass(Cobertura.class)
        			.addAnnotatedClass(HistorialPorcentajeCobertura.class)
        			.addAnnotatedClass(Usuario.class)
        			.addAnnotatedClass(PerfilUsuario.class)
        			.addAnnotatedClass(Localidad.class)
        			.addAnnotatedClass(Pais.class)
        			.addAnnotatedClass(Provincia.class)
        			.addAnnotatedClass(HistorialPorcentajeRiesgo.class)
        			.addAnnotatedClass(Marca.class)
        			.addAnnotatedClass(Modelo.class)
        			.addAnnotatedClass(HistorialEstadisticaRobo.class)
        			.addAnnotatedClass(SumaAsegurada.class)
        			.addAnnotatedClass(MedidaDeSeguridad.class)
        			.addAnnotatedClass(HistorialPorcentajeMedida.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionHibernate getInstance() {
        if (_INSTANCE == null) {
            synchronized (SessionHibernate.class) {
                if (_INSTANCE == null) {
                    _INSTANCE = new SessionHibernate();
                }
            }
        }
        return _INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void closeSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
