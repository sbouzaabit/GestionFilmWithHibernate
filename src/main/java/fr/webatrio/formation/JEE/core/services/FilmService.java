package fr.webatrio.formation.JEE.core.services;

import fr.webatrio.formation.JEE.core.DAO.HibernateFilmDAO;
import fr.webatrio.formation.JEE.core.DAO.JDBCFilmDAO;
import fr.webatrio.formation.JEE.core.models.Film;

import java.util.List;

/**
 * Created by Said B on 18/05/2017.
 */
public class FilmService {

    public void registerFilm ( Film f){
        //JDBCFilmDAO jdbc = new JDBCFilmDAO();
        HibernateFilmDAO hbn = new HibernateFilmDAO();
        hbn.saveFilm(f);
    }

    public Film retreiveFilm ( int id){
        //JDBCFilmDAO jdbc = new JDBCFilmDAO();
        HibernateFilmDAO hbn = new HibernateFilmDAO();
        return hbn.getFilm(id);
    }

    public List<Film> getAllFilms (){
        //JDBCFilmDAO jdbc = new JDBCFilmDAO();
        HibernateFilmDAO hbn = new HibernateFilmDAO();
        return hbn.getAllFilms();
    }
}
