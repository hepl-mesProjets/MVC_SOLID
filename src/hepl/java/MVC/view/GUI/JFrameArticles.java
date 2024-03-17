package hepl.java.MVC.view.GUI;

import hepl.java.MVC.controller.*;
import hepl.java.MVC.model.entity.Article;
import hepl.java.MVC.view.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class JFrameArticles extends JFrame implements ViewArticles {
    private JPanel mainPanel;
    private JTable table;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JMenuItem menuItemAddArticle;
    private JMenuItem menuItemDeleteArticle;
    private JMenuItem menuItemUpdateArticle;

    public JFrameArticles() {
        super("Gestion des articles");
        setContentPane(mainPanel);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Articles");
        menuItemAddArticle = new JMenuItem(ControllerActions.ADD);
        menu.add(menuItemAddArticle);
        menuItemUpdateArticle = new JMenuItem(ControllerActions.UPDATE);
        menu.add(menuItemUpdateArticle);
        menuItemDeleteArticle = new JMenuItem(ControllerActions.DELETE);
        menu.add(menuItemDeleteArticle);
        menu.addSeparator();
        JMenuItem menuItemQuit = new JMenuItem("Quitter");
        menuItemQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItemQuit);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        addButton.setText(ControllerActions.ADD);
        deleteButton.setText(ControllerActions.DELETE);
        updateButton.setText(ControllerActions.UPDATE);

        table.setModel(new ArticleTableModel(new ArrayList<>()));
        table.setColumnModel(new ArticleTableColumnModel());
    }

    @Override
    public Article promptForNewArticle() {
        JDialogArticle dialog = new JDialogArticle(this,null);
        dialog.setVisible(true);
        Article article = dialog.getArticle();
        dialog.dispose();
        return article;
    }

    @Override
    public Article promptForUpdateArticle(Article a) {
        JDialogArticle dialog = new JDialogArticle(this,a);
        dialog.setVisible(true);
        Article article = dialog.getArticle();
        dialog.dispose();
        return article;
    }

    @Override
    public Integer promptForArticleId() {
        int index = table.getSelectedRow();
        if (index == -1) return null;
        return ((ArticleTableModel)(table.getModel())).getArticleAt(index).getId();
    } 
    
    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Pour votre information...",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this,
                message,
                "Pour votre information...",
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void displayArticles(ArrayList<Article> articles) {
        table.setModel(new ArticleTableModel(articles));
        table.setColumnModel(new ArticleTableColumnModel());
    }

    @Override
    public void run() {
        setVisible(true);
    }

    @Override
    public void setController(Controller c) {
        addButton.addActionListener(c);
        deleteButton.addActionListener(c);
        updateButton.addActionListener(c);
        menuItemAddArticle.addActionListener(c);
        menuItemDeleteArticle.addActionListener(c);
        menuItemUpdateArticle.addActionListener(c);
    }

    public static void main(String[] args) {
        JFrameArticles fenetre = new JFrameArticles();
        //fenetre.setVisible(true);
        Article a = fenetre.promptForNewArticle();
        System.out.println("article = " + a);
        fenetre.showMessage("Nouvel Article effectué !");
        Article b = fenetre.promptForUpdateArticle(a);
        System.out.println("article = " + b);
    }
}
