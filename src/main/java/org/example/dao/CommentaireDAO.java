package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Commentaire;
import org.example.entity.Recette;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommentaireDAO extends BaseDAO<Commentaire> {
    private int nbRows;

    public CommentaireDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Commentaire element) throws SQLException {
        request = "INSERT INTO commentaire (id, commentaire, recette_id) VALUES (?, ?, ?)";

            statement = _connection.prepareStatement(request, statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, element.getId());
        statement.setString(2, element.getCommentaire());
            statement.setInt(3, element.getRecette_id());
            int nbRow = statement.executeUpdate();
            resultSet = statement.getGeneratedKeys();
            return nbRow == 1;

    }

    @Override
    public boolean update(Commentaire element) throws SQLException, ExecutionControl.NotImplementedException {
        return false;
    }

    @Override
    public boolean delete(Commentaire element) throws SQLException, ExecutionControl.NotImplementedException {
        request = "DELETE FROM commentaire WHERE idCommentaire = ?";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, element.getId());
            statement.execute();
            return nbRows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Commentaire> get() throws SQLException {
        List<Commentaire> commentaires = new ArrayList<>();
        request = "SELECT * FROM commentaire";
        try {
            statement = _connection.prepareStatement(request);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                commentaires.add(new Commentaire(
                        resultSet.getInt("idCommentaire"),
                        resultSet.getInt("idRecette"),
                        resultSet.getString("commentaire")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
        return commentaires;

    }

    @Override
    public List<Commentaire> getByName(String s) throws SQLException {
        return null;
    }

    @Override
    public Commentaire get(int id) throws SQLException {
        return null;
    }


    public List<Commentaire> getCommentByRecetteID(int recetteId) throws SQLException {
        List<Commentaire> result = new ArrayList<>();
        request = "SELECT * FROM recettes.commentaire where recette_id = ?";

            statement = _connection.prepareStatement(request);
            statement.setInt(1, recetteId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new Commentaire(
                        resultSet.getInt("id"),
                        resultSet.getInt("recette_id"),
                        resultSet.getString("commentaire")

                ));
            }
        return result;
    }



}
