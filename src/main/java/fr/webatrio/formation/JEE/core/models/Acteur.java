package fr.webatrio.formation.JEE.core.models;

import javax.persistence.*;

/**
 * Created by Said B on 23/05/2017.
 */
@Entity
@Table ( name="acteur")
public class Acteur {



    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    int idActeur;

    //sans specifier l'annotation Column
    String nom;
    String prenom;


    public int getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(int idActeur) {
        this.idActeur = idActeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
