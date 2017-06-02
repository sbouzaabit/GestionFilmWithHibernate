import fr.webatrio.formation.JEE.core.models.Film;
import fr.webatrio.formation.JEE.core.services.FilmService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*Film film = new Film("pk", "indien", 5);*/
        Film film = new Film();
        FilmService filmService = new FilmService();
        filmService.registerFilm(film);

       /* JDBCFilmDAO jdbc =  new JDBCFilmDAO();
        jdbc.getConnectionToMyDB();*/
/*
        MySQLClient MySQLClient = new MySQLClient("//localhost:3306/filmdb", "root", "");
        if (MySQLClient.connect()) {
            try {
                ResultSet rs = MySQLClient.exec("SELECT * FROM acteur");

                if (rs != null) {
                    while (rs.next()) {
                        System.out.println("Acteur : " + rs.getString("nom") + " " + rs.getString("prenom") );
                    }
                }

                //ajoute film
                MySQLClient.saveFilm(film);
                System.out.println("Film bien enregistré ");

            } catch (SQLException ex) {
                Logger.getLogger(MySQLClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Mysql connection failed !!!");
        }

        MySQLClient.close();*/
    }
}

