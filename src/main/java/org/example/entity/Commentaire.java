package org.example.entity;

public class Commentaire {

    private int id;

    private int recette_id;

    private String commentaire;

    public Commentaire(int id, int recette_id, String commentaire) {
        this.id = id;
        this.recette_id = recette_id;
        this.commentaire = commentaire;
    }

    public Commentaire(int recette_id, String commentaire) {
        this.recette_id = recette_id;
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRecette_id() {
        return recette_id;
    }

    public void setRecette_id(int recette_id) {
        this.recette_id = recette_id;
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
                "id=" + id +
                ", recette_id=" + recette_id +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
