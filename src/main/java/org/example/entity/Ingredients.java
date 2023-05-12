package org.example.entity;

public class Ingredients {

    private int idIngredients;

    private String nom;


    public Ingredients(int idIngredients, String nom) {
        this.idIngredients = idIngredients;
        this.nom = nom;
    }

    public Ingredients(String nom) {
        this.nom = nom;
    }

    public int getIdIngredients() {
        return idIngredients;
    }

    public void setIdIngredients(int idIngredients) {
        this.idIngredients = idIngredients;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Ingredients{" +
                "idIngredients=" + idIngredients +
                ", nom='" + nom + '\'' +
                '}';
    }
}
