package fr.webatrio.formation.JEE.core.models;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by Said B on 18/05/2017.
 */
@Entity
@Table ( name="film")
public class Film {



    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column (name="idFilm")
    int idUser;

    private String titre;

    @Column (name="type")
    private String genre;

    private Integer nbrExemplaire;


    @ManyToOne //(fetch=FetchType.LAZY)
    @JoinColumn(name="acteur_prin_id")
    private Acteur acteur;


    @ManyToMany (fetch=FetchType.EAGER)
    @Cascade(CascadeType.ALL)//(cascade = CascadeType.ALL)
    @JoinTable(name = "film_sec_acteur", joinColumns = { @JoinColumn(name = "Film_idFilm") }, inverseJoinColumns = { @JoinColumn(name = "Acteur_idActeur") })
    private Set<Acteur> acteurSecondaires;

    public Set<Acteur> getActeurSecondaires() {
        return acteurSecondaires;
    }

    public void setActeurSecondaires(Set<Acteur> acteurSecondaires) {
        this.acteurSecondaires = acteurSecondaires;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    /*  public Film (String t, String g, Integer nbrE){
          titre=t;
          genre=g;
          nbrExemplaire = nbrE;
      }*/
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getNbrExemplaire() {
        return nbrExemplaire;
    }

    public void setNbrExemplaire(Integer nbrExemplaire) {
        this.nbrExemplaire = nbrExemplaire;
    }
}
