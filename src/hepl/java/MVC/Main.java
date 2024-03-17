package hepl.java.MVC;

import hepl.java.MVC.controller.Controller;
import hepl.java.MVC.model.dao.DAOArticles;
import hepl.java.MVC.view.GUI.JFrameArticles;
import hepl.java.MVC.view.console.ViewArticlesConsole;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new DAOArticles(),new JFrameArticles());
        //Controller controller = new Controller(new DAOArticles(),new ViewArticlesConsole());

        controller.run();
    }
}
