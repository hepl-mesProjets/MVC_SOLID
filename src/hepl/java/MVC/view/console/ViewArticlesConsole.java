package hepl.java.MVC.view.console;

import hepl.java.MVC.controller.*;
import hepl.java.MVC.model.entity.*;
import hepl.java.MVC.view.ViewArticles;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Scanner;

public class ViewArticlesConsole implements ViewArticles {
    private Controller controller;
    private Scanner scanner;

    public ViewArticlesConsole() {
        scanner = new Scanner(System.in);
    }

    @Override
    public Article promptForNewArticle() {
        try {
            System.out.println("----- Nouvel Article -----");
            System.out.print("Intitulé = ");
            String intitule = promptConsoleForString();
            System.out.print("Prix = ");
            float prix = promptConsoleForFloat();
            System.out.print("Quantité = ");
            int quantite = promptConsoleForInt();
            System.out.print("En commande (true/false) = ");
            boolean enCommande = promptConsoleForBoolean();
            return new Article(intitule,prix,quantite,enCommande);
        } catch (ArticleException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Saisie incorrecte !!!");
        }
        return null;
    }

    @Override
    public Article promptForUpdateArticle(Article a) {
        try {
            System.out.println("----- Modification d'un article -----");
            System.out.println("Article à modifier = " + a);
            System.out.println(" 1) intitulé");
            System.out.println(" 2) prix");
            System.out.println(" 3) quantité");
            System.out.println(" 4) enCommande");
            System.out.print("Que voulez-vous modifier ? ");
            int choix = promptConsoleForInt();
            Article article = a.clone();
            switch (choix) {
                case 1 :
                    System.out.println("Ancien intitulé = " + a.getIntitule());
                    System.out.print("Nouvel intitulé = ");
                    String intitule = promptConsoleForString();
                    article.setIntitule(intitule);
                    break;
                case 2 :
                    System.out.println("Ancien prix = " + a.getPrix());
                    System.out.print("Nouveau prix = ");
                    float prix = promptConsoleForFloat();
                    article.setPrix(prix);
                    break;
                case 3 :
                    System.out.println("Ancienne quantité = " + a.getQuantite());
                    System.out.print("Nouvelle quantité = ");
                    int quantite = promptConsoleForInt();
                    article.setQuantite(quantite);
                    break;
                case 4 :
                    System.out.println("Ancien enCommande = " + a.isEnCommande());
                    System.out.print("Nouveau enCommande (true/false) = ");
                    boolean enCommande = promptConsoleForBoolean();
                    article.setEnCommande(enCommande);
                    break;
            }
            return article;
        } catch (ArticleException e) {
            System.out.println("Erreur : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Saisie incorrecte !!!");
        }
        return null;
    }

    @Override
    public Integer promptForArticleId() {
        try {
            System.out.println("----- Sélection d'un article -----");
            System.out.print("Id de l'article = ");
            int id = promptConsoleForInt();
            return id;
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Saisie incorrecte !!!");
        }
        return null;
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showErrorMessage(String message) {
        System.out.println("Erreur : " + message);
    }

    @Override
    public void displayArticles(ArrayList<Article> articles) {
        System.out.println("----- Liste des articles -----");
        for (Article a:articles)
            System.out.println(a);
    }

    @Override
    public void run() {
        while (true)
            promptForAction();
    }

    @Override
    public void setController(Controller c) {
        controller = c;
    }

    public void promptForAction() {
        try {
            System.out.println("----- MENU -----");
            System.out.println(" 1. Ajouter un article");
            System.out.println(" 2. Modifier un article");
            System.out.println(" 3. Supprimer un article");
            System.out.println(" 4. Quitter");
            System.out.print("Que voulez-vous faire ? ");
            int choix = promptConsoleForInt();
            switch (choix) {
                case 1:
                    controller.actionPerformed(new ActionEvent(this, 0, ControllerActions.ADD));
                    break;
                case 2:
                    controller.actionPerformed(new ActionEvent(this, 0, ControllerActions.UPDATE));
                    break;
                case 3:
                    controller.actionPerformed(new ActionEvent(this, 0, ControllerActions.DELETE));
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Erreur : Saisie incorrecte !!!");
        }
    }

    private String promptConsoleForString() {
        return scanner.nextLine();
    }

    private float promptConsoleForFloat() {
        String txt = scanner.nextLine();
        float nb = Float.parseFloat(txt); // !!!
        return nb;
    }

    private int promptConsoleForInt() {
        String txt = scanner.nextLine();
        int nb = Integer.parseInt(txt); // !!!
        return nb;
    }

    private boolean promptConsoleForBoolean() {
        String txt = scanner.nextLine();
        boolean b = Boolean.parseBoolean(txt); // !!!
        return b;
    }
}
