package org.example.entity;

public class Commentaire {

    private int idCommentaire;

    private int idRecette;

    private String commentaire;

    public Commentaire(int idCommentaire, int idRecette) {
        this.idCommentaire = idCommentaire;
        this.idRecette = idRecette;
    }

    public Commentaire(int idRecette) {
        this.idRecette = idRecette;
    }

    public Commentaire(int idCommentaire, int idRecette, String commentaire) {
    }

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public int getIdRecette() {
        return idRecette;
    }

    public void setIdRecette(int idRecette) {
        this.idRecette = idRecette;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "idCommentaire=" + idCommentaire +
                ", idRecette=" + idRecette +
                '}';
    }
}
