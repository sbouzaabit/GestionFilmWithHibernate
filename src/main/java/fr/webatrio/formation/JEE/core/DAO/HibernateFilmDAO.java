package fr.webatrio.formation.JEE.core.DAO;

import fr.webatrio.formation.JEE.core.models.Film;
import fr.webatrio.formation.JEE.core.DAO.util.HibernateUtil;
import org.hibernate.*;

import java.util.List;

/**
 * Created by Said B on 22/05/2017.
 */
public class HibernateFilmDAO {

    public void saveFilm(Film film) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Transaction tx = session.beginTransaction();
            session.persist(film);
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException ex2) {
                    ex2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Film getFilm(int id) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Film film = (Film) session.get(Film.class, id);
            //Hibernate.initialize(film.getActeur());
            return film;

        } catch (HibernateException ex) {
            ex.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException ex2) {
                    ex2.printStackTrace();
                }
            }
            return null;
        }
        finally {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Film> getAllFilms() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Query query = session.createQuery("from Film");
            List<Film> filmList = query.list();
            //Hibernate.initialize(film.getActeur());
            return filmList;

        } catch (HibernateException ex) {
            ex.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException ex2) {
                    ex2.printStackTrace();
                }
            }
            return null;
        }
        finally {
            if (session != null) {
                try {
                    session.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
