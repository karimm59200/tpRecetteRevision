package org.example.ihm;

import org.example.config.DataBaseSingleton;
import org.example.dao.RecetteDAO;
import org.example.entity.Recette;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IHM {

    Scanner scanner;

    String choix;

    private Connection connection;

    private RecetteDAO recetteDAO;

    public IHM(){
        scanner = new Scanner(System.in);
    }

    public void start() throws SQLException {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1": createRecetteAction();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
                case "10":
                    break;
                case "11":
                    break;
            }

        } while (!choix.equals("12"));
    }

    private void menu() {
        System.out.println("1- Entrez une recette.");
        System.out.println("2- Recherchez une recette par son nom.");
        System.out.println("3- Recherches une rectte par son nom.");

        System.out.println("Quitter");
    }


    private Recette createRecetteAction() throws SQLException {
        System.out.println("Merci de saisir le nom : ");
        String nom = scanner.nextLine();
        System.out.println("Merci de saisir la catégorie : ");
        String categorie = scanner.nextLine();
        System.out.println("Merci de saisir le temps de préparation : ");
        String duree = scanner.nextLine();
        System.out.println("Merci de saisir les instructions pour réaliser cette recette : ");
        String instruction = scanner.nextLine();
        Recette recette = new Recette(nom, categorie, duree, instruction);

        try {
            connection = new DataBaseSingleton().getInstance().getConnection();
            connection.setAutoCommit(false);
            recetteDAO = new RecetteDAO(this.connection);
            if (this.recetteDAO.save(recette)) {
                System.out.println("Recette ajouté " + recette.getId());
                this.connection.commit();
            } else {
                recette = null;

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            recette = null;
        }
        return recette;
    }

    private Recette DisplayRecetteByName(){
        System.out.println("merci de saisir le nom de la recette :");
        String nom = scanner.nextLine();



    }
}


