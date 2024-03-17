package hepl.java.MVC.controller;

import hepl.java.MVC.model.DataAccessLayer;
import hepl.java.MVC.model.entity.Article;
import hepl.java.MVC.view.ViewArticles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public final class Controller implements ActionListener {
    private DataAccessLayer model;
    private ViewArticles view;

    public Controller(DataAccessLayer model, ViewArticles view) {
        this.model = model;
        this.view = view;
        this.view.setController(this);
    }

    public void run() {
        view.run();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == ControllerActions.ADD) {
            Article a = view.promptForNewArticle();
            if (a != null) {
                model.addArticle(a);
                ArrayList<Article> articles = model.getList();
                view.displayArticles(articles);
                view.showMessage("Ajout effectué avec succès !");
            }
        }

        if (e.getActionCommand() == ControllerActions.DELETE) {
            Integer id = view.promptForArticleId();
            if (id == null) {
                view.showErrorMessage("Vous devez sélectionner un article !");
                return;
            }
            if (model.deleteArticle(id)) {
                view.displayArticles(model.getList());
                view.showMessage("Suppression effectuée avec succès !");
            } else {
                view.showErrorMessage("Erreur de suppression...");
            }
        }

        if (e.getActionCommand() == ControllerActions.UPDATE) {
            Integer id = view.promptForArticleId();
            if (id == null) {
                view.showErrorMessage("Vous devez sélectionner un article !");
                return;
            }
            Article a = model.getArticleById(id);
            if (a == null) {
                view.showErrorMessage("Erreur de modification...");
                return;
            }
            Article updatedA = view.promptForUpdateArticle(a);
            model.updateArticle(updatedA);
            view.displayArticles(model.getList());
            view.showMessage("Modification effectuée avec succès !");
        }
    }
}
