package hepl.java.MVC.view.GUI;

import hepl.java.MVC.model.entity.Article;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ArticleTableModel extends AbstractTableModel {
    private ArrayList<Article> articles;

    public ArticleTableModel(ArrayList<Article> data) {
        articles = data;
    }

    @Override
    public Class getColumnClass(int c) {
        if (c == 0) return Integer.class;
        if (c == 1) return String.class;
        if (c == 2) return Float.class;
        if (c == 3) return Integer.class;
        if (c == 4) return Boolean.class;
        return null;
    }

    @Override
    public int getRowCount() { return articles.size(); }

    @Override
    public int getColumnCount() { return 5; }

    @Override
    public Object getValueAt(int l,int c) {
        Article article = articles.get(l);
        if (c == 0) return article.getId();
        if (c == 1) return article.getIntitule();
        if (c == 2) return article.getPrix();
        if (c == 3) return article.getQuantite();
        if (c == 4) return article.isEnCommande();
        return null;
    }

    @Override
    public void setValueAt(Object value,int l,int c) {
    }

    @Override
    public boolean isCellEditable(int row,int column) {
        return false;
    }

    public Article getArticleAt(int index) {
        return articles.get(index);
    }
}
