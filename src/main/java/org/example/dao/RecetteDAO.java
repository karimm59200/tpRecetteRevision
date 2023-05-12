package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Commentaire;
import org.example.entity.Recette;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecetteDAO  extends BaseDAO<Recette> {


    private int nbRows;

    public RecetteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Recette element) throws SQLException {
        request = "INSERT INTO recette (nom, categorie, duree, instruction) VALUES (?, ?, ?, ?)";
        try {
            statement = _connection.prepareStatement(request);
            statement.setString(1, element.getNom());
            statement.setString(2, element.getCategorie());
            statement.setString(3, element.getDuree());
            statement.setString(4, element.getInstruction());
            statement.execute();
            return nbRows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

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
        List<Recette> recettes = new ArrayList<>();
        request = "SELECT * FROM recettes";
        try {
            statement = _connection.prepareStatement(request);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Recette get(int id) throws SQLException {
        request = "SELECT * FROM recettes WHERE id = ?";
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