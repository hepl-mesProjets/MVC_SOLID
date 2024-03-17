package hepl.java.MVC.view.GUI;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class ArticleTableColumnModel extends DefaultTableColumnModel {
    public ArticleTableColumnModel() {
        super();
        int[] taillesColonnes = {10,100,50,50,50};
        String[] nomsColonnes = {"Id","Intitulé","Prix","Quantité","En commande"};

        for (int i=0 ; i<taillesColonnes.length ; i++) {
            TableColumn c = new TableColumn(i,taillesColonnes[i]);
            c.setHeaderValue(nomsColonnes[i]);
            addColumn(c);
        }
    }
}
