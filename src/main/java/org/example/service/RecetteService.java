package org.example.service;

import org.example.config.DataBaseSingleton;
import org.example.dao.RecetteDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class RecetteService {

    private Connection connection;
    private RecetteDAO recetteDAO;

    public RecetteService(){
        try{
            connection = DataBaseSingleton.getInstance().getConnection();
            recetteDAO = new RecetteDAO(connection);
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
