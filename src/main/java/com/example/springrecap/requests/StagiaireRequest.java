package com.example.springrecap.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StagiaireRequest {

    @NotNull(message = "ce champ ne doit pas etre null")
    @Size(min = 3, message = "ce champ doit avoir au moins 3 caracteres")
    private String nom;

    @NotNull(message = "ce champ ne doit pas etre null")
    @Size(min = 3, message = "ce champ doit avoir au moins 3 caracteres")
    private String prenom;

    @NotNull(message = "ce champ ne doit pas etre null")
    private GroupeRequest groupe;

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

    public GroupeRequest getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeRequest groupe) {
        this.groupe = groupe;
    }
}
