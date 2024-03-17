package hepl.java.MVC.model;

import hepl.java.MVC.model.entity.Article;

import java.util.ArrayList;

public interface DataAccessLayer {
    int addArticle(Article article);

    boolean updateArticle(Article a);

    boolean deleteArticle(int id);

    boolean deleteArticle(Article a);

    Article getArticleById(int id);

    ArrayList<Article> getList();
}
