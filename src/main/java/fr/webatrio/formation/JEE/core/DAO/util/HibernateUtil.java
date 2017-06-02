package fr.webatrio.formation.JEE.core.DAO.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Said B on 22/05/2017.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {    //initialiser à partir du fichier hibernate.cfg.xml
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}



