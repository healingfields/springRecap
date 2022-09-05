package com.example.springrecap.dtos;

import java.io.Serializable;

public class StagiaireDto implements Serializable {

    private static final long serialVersionUID = -13728473802L;

    private long id;

    private String nom;

    private String prenom;

    private String stagiaireId;

    private GroupeDto groupe;

    public long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;
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

    public String getStagiaireId() {
        return stagiaireId;
    }

    public void setStagiaireId(String stagiaireId) {
        this.stagiaireId = stagiaireId;
    }

    public GroupeDto getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeDto groupe) {
        this.groupe = groupe;
    }
}
