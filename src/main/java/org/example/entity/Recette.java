package org.example.entity;

public class Recette {

    private int idRecette;

    private String nom;

    private String categorie;

    private String duree;

    private  String instruction;

    public Recette(int idRecette, String nom, String categorie, String duree, String instruction) {
        this.idRecette = idRecette;
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

    public int getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(int idRecette) {
        this.idRecette = idRecette;
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
                "idRecette=" + idRecette +
                ", nom='" + nom + '\'' +
                ", categorie='" + categorie + '\'' +
                ", duree='" + duree + '\'' +
                ", instruction='" + instruction + '\'' +
                '}';
    }
}
