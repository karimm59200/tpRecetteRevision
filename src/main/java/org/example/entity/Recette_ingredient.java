package org.example.entity;

public class Recette_ingredient {

    private int id;
    private int recette_id;
    private int ingredient_id;

    public Recette_ingredient(int id, int recette_id, int ingredient_id) {
        this.id = id;
        this.recette_id = recette_id;
        this.ingredient_id = ingredient_id;
    }

    public Recette_ingredient(int recette_id, int ingredient_id) {
        this.recette_id = recette_id;
        this.ingredient_id = ingredient_id;
    }

    public int getId() {
        return id;
    }

    public int getRecette_id() {
        return recette_id;
    }

    public void setRecette_id(int recette_id) {
        this.recette_id = recette_id;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(int ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    @Override
    public String toString() {
        return "Recette_ingredient{" +
                "id=" + id +
                ", recette_id=" + recette_id +
                ", ingredient_id=" + ingredient_id +
                '}';
    }
}
