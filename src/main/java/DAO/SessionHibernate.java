package DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entidades.Cliente;

public class SessionHibernate {

    private static SessionHibernate _INSTANCE;
    private static final SessionFactory sessionFactory;

    private SessionHibernate() {
    }

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class)
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

    public static SessionFactory getSession() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
