package org.example.service;

import org.example.config.DataBaseSingleton;
import org.example.dao.CommentaireDAO;
import org.example.dao.IngredientDAO;
import org.example.dao.RecetteDAO;
import org.example.entity.Commentaire;
import org.example.entity.Ingredient;
import org.example.entity.Recette;
import org.example.entity.RecetteDetail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RecetteService {

    private Connection connection;
    private RecetteDAO recetteDAO;
    private IngredientDAO ingredientDAO;
    private CommentaireDAO commentaireDAO;

    public RecetteService(){
        try{
            connection = DataBaseSingleton.getInstance().getConnection();
            connection.setAutoCommit(false);
            recetteDAO = new RecetteDAO(connection);
            ingredientDAO = new IngredientDAO(connection);
            commentaireDAO = new CommentaireDAO(connection);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    /*public boolean saveRecette(String nom, String categorie, String duree, String instruction){
        try{
            if(recetteDAO.save(nom, categorie, duree, instruction)){
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }*/

    public RecetteDetail getRecetteDetail(String nomRecette){
        RecetteDetail result = new RecetteDetail();
        try {
            // recuperer une liste de recette selon le nom aproprier
            List<Recette> recetteList = recetteDAO.getByName(nomRecette);

            List<Ingredient> ingredientList;
            List<Commentaire> commentaireList;

            // on doit boucler sur la liste des recettes recuperé pour avoir chaque recette
            for (int i=0; i< recetteList.size(); i++) {

                // recetteList.get(i) = l'objet courant "recette" d'ou le "i" fait reference a l'index de l'objet courant
                // pour chaque recette on recupère la liste d'ingredients par l'id de la recette
                ingredientList = ingredientDAO.getIngedientsByRecetteID(recetteList.get(i).getId());

                // pour chaque recette on recupère la liste de commentaire par l'id de la recette
                commentaireList = commentaireDAO.getCommentByRecetteID(recetteList.get(i).getId());

                // construction de notre objet RecetteDetail
                result.setRecette(recetteList.get(i));
                result.setIngredients(ingredientList);
                result.setCommentaires(commentaireList);
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}
