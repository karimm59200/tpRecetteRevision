package org.example.dao;

import jdk.jshell.spi.ExecutionControl;
import org.example.entity.Commentaire;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommentaireDAO extends BaseDAO<Commentaire> {
    private int nbRows;

    protected CommentaireDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean save(Commentaire element) throws SQLException {
        request = "INSERT INTO commentaire (idCommentaire, idRecette, commentaire) VALUES (?, ?, ?)";
        try {
            statement = _connection.prepareStatement(request);
            statement.setInt(1, element.getIdCommentaire());
            statement.setInt(2, element.getIdRecette());
            statement.setString(3, element.getCommentaire());
            statement.execute();
            return nbRows  == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
            statement.setInt(1, element.getIdCommentaire());
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
    public Commentaire get(int id) throws SQLException {

        return null;
    }
}
