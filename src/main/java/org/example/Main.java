package org.example;

import org.example.config.DataBaseSingleton;
import org.example.dao.CommentaireDAO;
import org.example.dao.IngredientDAO;
import org.example.dao.RecetteDAO;
import org.example.entity.Commentaire;
import org.example.entity.Ingredient;
import org.example.entity.Recette;
import org.example.entity.RecetteDetail;
import org.example.ihm.IHM;
import org.example.service.RecetteService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static RecetteDAO recetteDAO;

    private static CommentaireDAO commentaireDAO;

    private static Connection connection;
    private static RecetteService recetteService = new RecetteService();
   public static void main(String[] args) throws SQLException {

//       List<Recette> rArray = new ArrayList<>(List.of(new Recette[]{
//               new Recette("Couscous", "Plat", "1h30", "Coupez le collier d'agneau en gros cubes.\n" +
//                       "Dans une sauteuse, faites chauffer l'huile d'olive. Faites-y colorer les oignons, retirez-les et mettez l'agneau et le poulet à la place. Faites revenir quelques min.\n" +
//                       "Ajoutez le céleri et les carottes épluchés et coupés en tronçons, les navets épluchés et coupés en 4 et les pois chiches égouttés. Ajoutez le concentré de tomate, le ras el hanout, la harissa et une pincée de sel. Remettez les oignons et l'ail écrasé.\n" +
//                       "Couvrez d'eau à hauteur et portez à frémissements. Laissez mijoter 1 h à couvert.\n" +
//                       "Faites gonfler la semoule dans 1 fois et demi son volume d'eau. Égrainez-la avec le beurre coupé en parcelles.\n" +
//                       "Faites griller les merguez à sec dans une poêle.\n" +
//                       "Servez le couscous accompagné de semoule, de viande et de merguez, de légumes et de bouillon."),
//
//               new Recette("Poulet", "Plat", "1h30", "Préchauffer le four thermostat 7/8 (200°).\n" +
//                       "Laver les pommes de terre, les mettre dans une casserole, couvrir d'eau froide, porter à ébullition, laisser cuire 5 min puis les rafraîchir sous l'eau froide.\n" +
//                       "Frotter le poulet avec la moitié de la fleur de sel et les brindilles de thym, poivrer, le ficeler.\n" +
//                       "Mettre le poulet dans un plat, l'arroser d'huile d'olive. Mettre le poulet à cuire dans le four préchauffé.\n" +
//                       "Au bout de 15 min, baisser le four thermostat 6 (180°).\n" +
//                       "Répartir les pommes de terre et les gousses d'ail autour du poulet, remettre le poulet à cuire 1h en le retournant toutes les 15 min et en l'arrosant.\n" +
//                       "Sortir le poulet du four, le laisser reposer 15 min. Saupoudrer le poulet et les pommes de terre avec le reste de fleur de sel avant de déguster.Quelques astuces en vidéo pour savoir si votre poulet est cuit :"),
//               new Recette("Poisson", "Plat", "1h30", "Préchauffez le four à 220 °C. Placez la dorade dans un plat à four. Placez le bâton de citronnelle sous l'un des filets.\n" +
//                       "Dans un bol, mélangez l'huile d'olive, le jus de citron, du sel et du poivre. Ajoutez le piment ciselé finement, le gingembre haché et les oignons ciselés.\n" +
//                       "Répartissez cette sauce sur la dorade. Enfournez le poisson pour 30 minutes.\n" +
//                       "Parsemez la dorade cuite de coriandre ciselée, donnez un tour de poivre du moulin, ajoutez éventuellement une pincée de fleur de sel. Servez aussitôt."),
//               new Recette("Salade", "Plat", "1h30", "Percez la base de vos œufs à l’aide d’un perce-œuf. Plongez-les dans une casserole remplie d’eau bouillante et faites-les cuire 9 minutes. Rafraîchissez-les puis écalez-les avec soin. Coupez vos œufs en tranches.\n" +
//                       "Plongez vos haricots verts surgelées dans une casserole remplie d’eau bouillante salée et faites-les cuire 5 minutes à partir de la reprise de l’ébullition. Rafraichissez-les immédiatement dans de l’eau avec des glaçons. Égouttez-les. Coupez-les en tronçons.\n" +
//                       "Lavez et essorez la roquette.\n" +
//                       "Lavez vos tomates cerise, coupez-les en tranches.\n" +
//                       "Égouttez le thon en boite.\n" +
//                       "Coupez les pommes de terre en tranches.\n" +
//                       "Coupez les olives noires en morceaux.\n" +
//                       "Dans un bol, mélangez le vinaigre de Xérès avec la moutarde de Dijon, du sel et du poivre. Ajoutez petit à petit l’huile d’olive tout en mélangeant.\n" +
//                       "Faites le montage de votre salade en vous reposant sur la photo d’illustration.\n" +
//                       "Arrosez de vinaigrette"),
//               new Recette("Pates", "Plat", "1h30", "Faire cuire les pates"),
//               new Recette("Pizza", "Plat", "1h30", "Faire cuire la pizza"),
//               new Recette("Riz", "Plat", "1h30", "Faire cuire le riz"),
//               new Recette("Pomme de terre", "Plat", "1h30", "Faire cuire les pommes de terre"),
//
//       }));
//       for (Recette r : rArray) {
//           try {
//               connection = DataBaseSingleton.getInstance().getConnection();
//               connection.setAutoCommit(false);
//               recetteDAO = new RecetteDAO(connection);
//               System.out.println("J'entre une recette");
//               if (recetteDAO.save(r)) {
//                   System.out.println("Ingredient " + r.getNom() + " "+ r.getInstruction() +" ajouté");
//
//                   connection.commit();
//               } else {
//                     connection.rollback();
//               }
//           } catch (SQLException e) {
//               System.out.println(e.getMessage());
//           }
//       }

       /*try {
           connection = DataBaseSingleton.getInstance().getConnection();
           connection.setAutoCommit(false);
           recetteDAO = new RecetteDAO(connection);
           System.out.println("J'entre une recette");
           List<Recette> recetteList = recetteDAO.getByName("Cous");
           connection.commit();
              for (Recette r : recetteList) {
                System.out.println(r.toString());
              }
       } catch (SQLException e) {
           System.out.println(e.getMessage());
       }*/
//      RecetteDetail recetteDetail = recetteService.getRecetteDetail("Couscous");
//       System.out.println(recetteDetail.toString());


       /*List<Commentaire> commentaireList = new ArrayList<>(List.of(new Commentaire[]{
               new Commentaire(41, "il n'est pas aussi bon que celui de ma mère."),
               new Commentaire(41, "très bon."),
               new Commentaire(41, "je préfère le couscous Marocain."),
       }));
       for (Commentaire c : commentaireList) {
           try {
               connection = DataBaseSingleton.getInstance().getConnection();
               connection.setAutoCommit(false);
               commentaireDAO = new CommentaireDAO(connection);
               System.out.println("J'entre une recette");
               if (commentaireDAO.save(c)) {
                   System.out.println("commentaire ajouté");

                   connection.commit();
               } else {
                   connection.rollback();
               }
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
       }*/

       new IHM().start();
   }
}