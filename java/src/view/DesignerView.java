package view;

import menu.Menu;
import menu.MenuItem;

public class DesignerView {

    private static Menu mainmenu = null;

    private DesignerView(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    public static void createDesignerMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** Designers's basic Menu ***");
        mainmenu.addItem(new MenuItem("View All Issues", mainmenu, "viewAllIssues"));
        mainmenu.addItem(new MenuItem("Post an Issue", mainmenu, "postAnIssue"));
        mainmenu.addItem(new MenuItem("Logout", mainmenu, "logout"));

        DesignerView designerMenu = new DesignerView(mainmenu);
    }

    public static void displayDesignerMenu() {
        mainmenu.execute();
    }
}
