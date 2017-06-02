package fr.webatrio.formation.JEE.core.models;

import javax.persistence.*;

/**
 * Created by Said B on 22/05/2017.
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    @Column (name="id")
    int idUser;

    //sans specifier l'annotation Column
    String login;
    String motDePass;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public void setMotDePass(String motDePass) {
        this.motDePass = motDePass;
    }
}
