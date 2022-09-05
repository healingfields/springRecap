package com.example.springrecap.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "groupes")
public class Groupe implements Serializable {

    private static final long serialVersionUID = -9244682047230534L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 32)
    private String groupeId;

    @Column(nullable = false, length = 50)
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
