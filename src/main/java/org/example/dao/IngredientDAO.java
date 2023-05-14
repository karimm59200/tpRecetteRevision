package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Ingredient;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class IngredientDAO  extends BaseDAO<Ingredient>{
    private int nbRows;

    public IngredientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Ingredient element) throws SQLException {
        request = "INSERT INTO ingredient (nom) VALUES (?)";
        statement = _connection.prepareStatement(request, statement.RETURN_GENERATED_KEYS);
        statement.setString(1, element.getNom());
        int nbRow = statement.executeUpdate();
        resultSet = statement.getGeneratedKeys();

        return nbRow == 1;
    }



    @Override
    public boolean update(Ingredient element) throws SQLException, ExecutionControl.NotImplementedException {
        return false;
    }

    @Override
    public boolean delete(Ingredient element) throws SQLException, ExecutionControl.NotImplementedException {
        return false;
    }

    @Override
    public List<Ingredient> get() throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        request = "SELECT * FROM ingredient";
        try{
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingredients.add(new Ingredient(
                        resultSet.getInt("id"),
                        resultSet.getString("nom")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Ingredient> getByName(String s) throws SQLException {
        return null;
    }

    @Override
    public Ingredient get(int id) throws SQLException {
        return null;
    }


    public List<Ingredient> getIngedientsByRecetteID(int recetteID) throws SQLException {
        List<Ingredient> ingredients = new ArrayList<>();
        request = "select i.id, i.nom from ingredient as i LEFT OUTER JOIN recette_ingredient as ri on i.id = ri.ingredient_id where ri.recette_id = ?;";
            statement = _connection.prepareStatement(request);
        statement = _connection.prepareStatement(request);
        statement.setString(1, String.valueOf(recetteID));
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingredients.add(new Ingredient(
                        resultSet.getInt("id"),
                        resultSet.getString("nom")
                ));
            }


        return ingredients;
    }
}
