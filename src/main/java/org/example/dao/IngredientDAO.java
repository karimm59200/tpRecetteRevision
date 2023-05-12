package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Commentaire;
import org.example.entity.Ingredients;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class IngredientDAO  extends BaseDAO<Ingredients>{
    private int nbRows;

    protected IngredientDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Ingredients element) throws SQLException {
        request = "INSERT INTO ingredients (nom,) VALUES (?)";
        try {
            statement = _connection.prepareStatement(request);
            statement.setString(1, element.getNom());
            statement.execute();
            return nbRows  == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean update(Ingredients element) throws SQLException, ExecutionControl.NotImplementedException {
        return false;
    }

    @Override
    public boolean delete(Ingredients element) throws SQLException, ExecutionControl.NotImplementedException {
        return false;
    }

    @Override
    public List<Ingredients> get() throws SQLException {
        List<Ingredients> ingredients = new ArrayList<>();
        request = "SELECT * FROM ingredients";
        try{
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ingredients.add(new Ingredients(
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
    public Ingredients get(int id) throws SQLException {

        return null;
    }
}
