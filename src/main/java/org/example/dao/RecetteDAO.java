package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Commentaire;
import org.example.entity.Recette;

import java.sql.Array;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAO  extends BaseDAO<Recette> {


    private int nbRows;



    public RecetteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Recette element) throws SQLException {
        request = "INSERT INTO recette (nom,  categorie, duree, instruction) VALUES (?, ?,?, ? )";
            statement = _connection.prepareStatement(request, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, element.getNom());
            statement.setString(2, element.getCategorie());
            statement.setString(3, element.getDuree());
            statement.setString(4, element.getInstruction());
            int nbRow = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();

            return nbRow == 1;

    }

    @Override
    public boolean update(Recette element) throws SQLException, ExecutionControl.NotImplementedException {
        return false;
    }

    @Override
    public boolean delete(Recette element) throws SQLException, ExecutionControl.NotImplementedException {
        return false;
    }

    @Override
    public List<Recette> get() throws SQLException {
        return null;
    }

    @Override
    public List<Recette> getByName(String nomRecette) throws SQLException {
        List<Recette> recettes = new ArrayList<>();
        request = "SELECT * FROM recette where nom like ?";
        statement = _connection.prepareStatement(request);
        statement.setString(1, "%"+nomRecette+"%");
        resultSet = statement.executeQuery();
            while (resultSet.next()) {
                recettes.add(new Recette(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("categorie"),
                        resultSet.getString("duree"),
                        resultSet.getString("instruction")
                ));
            }
            return recettes;
    }



    @Override
    public Recette get(int id) throws SQLException {
        request = "SELECT * FROM recette WHERE id = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Recette(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("categorie"),
                        resultSet.getString("duree"),
                        resultSet.getString("instruction")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}