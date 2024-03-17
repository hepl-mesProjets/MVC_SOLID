package hepl.java.MVC.view;

import hepl.java.MVC.controller.Controller;
import hepl.java.MVC.model.entity.Article;

import java.util.ArrayList;

public interface ViewArticles {
    Article promptForNewArticle();

    Article promptForUpdateArticle(Article a);

    Integer promptForArticleId();

    void showMessage(String message);

    void showErrorMessage(String message);

    void displayArticles(ArrayList<Article> articles);

    void run();

    void setController(Controller c);
}
