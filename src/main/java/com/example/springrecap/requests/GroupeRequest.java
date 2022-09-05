package com.example.springrecap.requests;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GroupeRequest {

    private String groupeId;

    @NotNull(message = "ce champ ne doit pas etre vide")
    @Size(min=3, message = "ce champ doit avoir au moins 3 characteres")
    private String nom;

    public String getGroupeId() {
        return groupeId;
    }

    public void setGroupeId(String groupeId) {
        this.groupeId = groupeId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
