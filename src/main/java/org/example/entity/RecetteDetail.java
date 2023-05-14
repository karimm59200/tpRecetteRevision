package org.example.entity;

import java.util.List;

public class RecetteDetail {

    private Recette recette;

    private List<Ingredient> ingredients;
    private List<Commentaire> commentaires;

    public RecetteDetail(Recette recette, List<Ingredient> ingredients, List<Commentaire> commentaires) {
        this.recette = recette;
        this.ingredients = ingredients;
        this.commentaires = commentaires;
    }

    public RecetteDetail() {
    }

    public Recette getRecette() {
        return recette;
    }

    public void setRecette(Recette recette) {
        this.recette = recette;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @Override
    public String toString() {
        return "RecetteDetail{" +
                "recette=" + recette +
                ", \n ingredients=" + ingredients +
                ", \n commentaires=" + commentaires +
                '}';
    }
}
