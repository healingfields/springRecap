package com.example.springrecap.responses;

public class StagiaireResponse {

    private String nom;

    private String prenom;

    private String stagiaireId;

    private GroupeResponse groupe;

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

    public GroupeResponse getGroupe() {
        return groupe;
    }

    public void setGroupe(GroupeResponse groupe) {
        this.groupe = groupe;
    }
}
