package org.example.entity;

public class Ingredient {

    private int id;

    private String nom;

    public Ingredient(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Ingredient(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
