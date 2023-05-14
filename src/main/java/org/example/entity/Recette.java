package org.example.entity;

import java.util.List;

public class Recette {

    private int id;

    private String nom;

    private String categorie;

    private String duree;

    private  String instruction;

    public Recette(int id, String nom, String categorie, String duree, String instruction) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.duree = duree;
        this.instruction = instruction;
    }

    public Recette(String nom, String categorie, String duree, String instruction) {
        this.nom = nom;
        this.categorie = categorie;
        this.duree = duree;
        this.instruction = instruction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "Recette{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", categorie='" + categorie + '\'' +
                ", duree='" + duree + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
