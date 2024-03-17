package hepl.java.MVC.view.GUI;

import hepl.java.MVC.model.entity.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDialogArticle extends JDialog {
    private JPanel mainPanel;
    private JTextField idTextField;
    private JTextField intituleTextField;
    private JTextField prixTextField;
    private JSpinner quantiteSpinner;
    private JCheckBox enCommandeCheckBox;
    private JButton validerButton;
    private JButton annulerButton;
    private Article article;

    public JDialogArticle(JFrameArticles parent, Article a) {
        super(parent,"Nouvel Article...",true);
        setSize(350,220);
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        setContentPane(mainPanel);
        quantiteSpinner.setModel(new SpinnerNumberModel(5,0,null,1));

        article = new Article();

        if (a != null) {
            setTitle("Modifier Article...");
            validerButton.setText("Modifier");
            idTextField.setText(String.valueOf(a.getId()));
            intituleTextField.setText(a.getIntitule());
            prixTextField.setText(String.valueOf(a.getPrix()));
            quantiteSpinner.getModel().setValue(a.getQuantite());
            enCommandeCheckBox.setSelected(a.isEnCommande());

            article.setId(a.getId());
        }

        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    article.setIntitule(intituleTextField.getText());
                    article.setPrix(Float.parseFloat(prixTextField.getText()));
                    article.setQuantite((Integer) quantiteSpinner.getValue());
                    article.setEnCommande(enCommandeCheckBox.isSelected());
                    setVisible(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(getParent(),
                            "Mauvais format de prix !",
                            "Erreur !",
                            JOptionPane.ERROR_MESSAGE);
                } catch (ArticleException ex) {
                    JOptionPane.showMessageDialog(getParent(),
                            ex.getMessage(),
                            "Erreur !",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        annulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                article = null;
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) throws ArticleException {
        //JDialogArticle dialog = new JDialogArticle(null,null);
        JDialogArticle dialog = new JDialogArticle(null,
                new Article("pommes",
                        5.56f,
                        4,
                        true));
        dialog.setVisible(true);
    }

    public Article getArticle() {
        return article;
    }
}
