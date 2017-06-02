package fr.webatrio.formation.JEE.core.DAO;

import fr.webatrio.formation.JEE.core.models.Film;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Said B on 18/05/2017.
 */
public class JDBCFilmDAO {

    private String dbURL = "";
    private String user = "";
    private String password = "";
    private java.sql.Connection dbConnect = null;
    private java.sql.Statement dbStatement = null;
    
    /**
     * Connecter à la base de donnée
     * @return false en cas d'échec
     */
    public Boolean connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.dbConnect = DriverManager.getConnection("jdbc:mysql:" + this.dbURL, this.user, this.password);
            this.dbStatement = this.dbConnect.createStatement();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(JDBCFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(JDBCFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Executer une requete SQL
     * @param sql
     * @return resultat de la requete
     */
    public ResultSet exec(String sql) {
        try {
            ResultSet rs = this.dbStatement.executeQuery(sql);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void saveFilm(Film film) {
        try {
            PreparedStatement ps = this.dbConnect.prepareStatement("insert into film (idFilm, titre, type, nbrExemplaire) values (?,?,?,?)");

            ps.setInt(1, 1);
            ps.setString(2, film.getTitre());
            ps.setString(3, film.getGenre());
            ps.setInt(4, film.getNbrExemplaire() );
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    /**
     * Fermer la connexion au serveur de DB
     */
    public void close() {
        try {
            this.dbStatement.close();
            this.dbConnect.close();
        } catch (SQLException ex) {
            Logger.getLogger(JDBCFilmDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    public void getConnectionToMyDB(String url, String user, String password) {

        try{
            // 1-connection to DB
            Connection myCon = DriverManager.getConnection(url, user, password);
            //2-create statement
            Statement myStm = myCon.createStatement();
            //3-execute sql Query
            ResultSet myRs = myStm.executeQuery("select * from acteur");
            //4-Processthe resultSet
            while (myRs.next()){
                System.out.println("Acteur : " + myRs.getString("nom") + " " + myRs.getString("prenom") );

            }
        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
    }
}

