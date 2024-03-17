package hepl.java.MVC.model.dao;

import hepl.java.MVC.model.DataAccessLayer;
import hepl.java.MVC.model.entity.Article;
import hepl.java.MVC.model.entity.ArticleException;

import java.util.ArrayList;

public class DAOArticles implements DataAccessLayer {
    private ArrayList<Article> articles;
    private static int idCourant = 1;

    public DAOArticles() {
        articles = new ArrayList<>();
    }

    @Override
    public int addArticle(Article article) {
        if (article == null) return -1;
        article.setId(idCourant);
        idCourant++;
        articles.add(article);
        return article.getId();
    }

    @Override
    public boolean updateArticle(Article a) {
        for (int i=0 ; i<articles.size() ; i++) {
            if (articles.get(i).getId() == a.getId()) {
                articles.set(i,a);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteArticle(int id) {
        for (Article a:articles) {
            if (a.getId() == id) {
                articles.remove(a);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteArticle(Article a) {
        for (Article article:articles) {
            if (article.equals(a)) {
                articles.remove(article);
                return true;
            }
        }
        return false;
    }

    @Override
    public Article getArticleById(int id) {
        for (Article a:articles) {
            if (a.getId() == id) {
                return a.clone();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "DAOArticles{" +
                "articles=" + articles +
                '}';
    }

    @Override
    public ArrayList<Article> getList() {
        ArrayList<Article> copy = new ArrayList<>();
        for (Article a:articles) {
            copy.add(a.clone());
        }
        return copy;
    }

    public static void main(String[] args) {
        DataAccessLayer dao = new DAOArticles();
        try {
            dao.addArticle(new Article("pommes",2.23f,15,false));
            dao.addArticle(new Article("oranges",3.36f,35,true));
            dao.addArticle(new Article("bananes",5.32f,17,false));
            dao.addArticle(new Article("cerises",5.06f,8,true));
            System.out.println(dao);
            Article a = dao.getArticleById(3);
            System.out.println("Article ayant l'id 3 = " + a);
            a.setQuantite(25);
            a.setPrix(8.63f);
            dao.updateArticle(a);
            System.out.println(dao);
            dao.deleteArticle(2);
            System.out.println(dao);
        } catch (ArticleException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
