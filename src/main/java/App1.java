import fr.webatrio.formation.JEE.core.models.Acteur;
import fr.webatrio.formation.JEE.core.models.Film;
import fr.webatrio.formation.JEE.core.services.FilmService;

import java.util.List;

/**
 * Created by Said B on 22/05/2017.
 */
public class App1 {

    public static void main (  String arg[]){

        /*SessionFactory session = HibernateUtil.getSessionFactory();
        Session s = session.openSession();*/

        Film f = new Film();
        f.setTitre("madmax");
        f.setGenre("aventure");
        f.setNbrExemplaire(5);
        FilmService filmService =  new FilmService();
        Film film = filmService.retreiveFilm(2);

        //filmService.registerFilm(f);
        System.out.println("film recuperé : " + film.getTitre());
        for (Acteur acteur : film.getActeurSecondaires()) {
            System.out.println("acteur recuperé : ");
        }
        System.out.println("acteur recuperé : " + film.getActeurSecondaires().size());
        //System.out.println("Film Added avec succes");

//persister en cascade
  /*      Acteur acteurSecondaire1 = new Acteur();
        acteurSecondaire1.setNom("said");
        acteurSecondaire1.setPrenom("bouzaabit");

        Acteur acteurSecondaire2 = new Acteur();
        acteurSecondaire2.setNom("said2");
        acteurSecondaire2.setPrenom("bouzaabit2");


        Film filmAPersiste = new Film();
        filmAPersiste.setTitre("wje3 trab");
        filmAPersiste.setGenre("social");
        Set<Acteur> listActeurSec = new HashSet<Acteur>();
        filmAPersiste.setNbrExemplaire(2);
        listActeurSec.add(acteurSecondaire1);
        listActeurSec.add(acteurSecondaire2);
        filmAPersiste.setActeurSecondaires(listActeurSec);
        filmService.registerFilm(filmAPersiste);
*/
  //get all Film
        List<Film> filmList = filmService.getAllFilms();
        System.out.println("Liste de tous les films: " + f.getTitre());
        for (Film flm : filmList) {
            System.out.println("titre du film : " + flm.getTitre());
        }
    }
}
