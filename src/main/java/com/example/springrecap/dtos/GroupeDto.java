package com.example.springrecap.dtos;

import java.io.Serializable;

public class GroupeDto implements Serializable {

    private static final long serialVersionUID = -13223424456546L;

    private long id;

    private String groupeId;

    private String nom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
