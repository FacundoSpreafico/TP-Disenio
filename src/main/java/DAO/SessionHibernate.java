package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entidades.Cliente;
import entidades.Cobertura;
import entidades.Cuota;
import entidades.DescuentoPorUnidadAdicional;
import entidades.HijoCliente;
import entidades.HistorialDerechoEmision;
import entidades.HistorialDescuentoPorUnidadAdicional;
import entidades.HistorialEstadisticaRobo;
import entidades.HistorialPolizaModificada;
import entidades.HistorialPorcentajeCobertura;
import entidades.HistorialPorcentajeHijo;
import entidades.HistorialPorcentajeKM;
import entidades.HistorialPorcentajeMedida;
import entidades.HistorialPorcentajeRiesgo;
import entidades.HistorialPorcentajeSiniestros;
import entidades.Localidad;
import entidades.Marca;
import entidades.MedidaDeSeguridad;
import entidades.Modelo;
import entidades.Pago;
import entidades.Pais;
import entidades.PerfilUsuario;
import entidades.Poliza;
import entidades.PorcentajeMedida;
import entidades.PorcentajePorHijo;
import entidades.PorcentajePorKms;
import entidades.PorcentajePorSiniestros;
import entidades.Provincia;
import entidades.SumaAsegurada;
import entidades.Usuario;
import entidades.Vehiculo;

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
        			.addAnnotatedClass(Poliza.class)
        			.addAnnotatedClass(HistorialDerechoEmision.class)
        			.addAnnotatedClass(HistorialDescuentoPorUnidadAdicional.class)
        			.addAnnotatedClass(HistorialPorcentajeHijo.class)
        			.addAnnotatedClass(HistorialPorcentajeKM.class)
        			.addAnnotatedClass(HistorialPorcentajeSiniestros.class)
        			.addAnnotatedClass(HistorialPolizaModificada.class)
        			.addAnnotatedClass(Vehiculo.class)
        			.addAnnotatedClass(DescuentoPorUnidadAdicional.class)
        			.addAnnotatedClass(PorcentajePorHijo.class)
        			.addAnnotatedClass(PorcentajePorKms.class)
        			.addAnnotatedClass(PorcentajePorSiniestros.class)
        			.addAnnotatedClass(HijoCliente.class)
        			.addAnnotatedClass(Cuota.class)
        			.addAnnotatedClass(Pago.class)
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
