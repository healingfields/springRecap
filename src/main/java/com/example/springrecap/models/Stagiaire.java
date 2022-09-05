package com.example.springrecap.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "stagiaires")
public class Stagiaire implements Serializable {

    private static final long serialVersionUID = -353819548292L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 32)
    private String stagiaireId;

    @Column(nullable = false, length = 50)
    private String nom;

    @Column(nullable = false, length = 50)
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "groupes_id")
    private Groupe groupe;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStagiaireId() {
        return stagiaireId;
    }

    public void setStagiaireId(String stagiaireId) {
        this.stagiaireId = stagiaireId;
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

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
}
