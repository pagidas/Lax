package view;

import menu.Menu;
import menu.MenuItem;

public class DeveloperView {

    private static Menu mainmenu = null;

    private DeveloperView(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    public static void createDeveloperMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** Developer's basic Menu ***");
        mainmenu.addItem(new MenuItem("View All Issues", mainmenu, "viewAllIssues"));
        mainmenu.addItem(new MenuItem("Post an Issue", mainmenu, "postAnIssue"));
        mainmenu.addItem(new MenuItem("Logout", mainmenu, "logout"));

        DeveloperView developerMenu = new DeveloperView(mainmenu);
    }

    public static void displayDeveloperMenu() {
        mainmenu.execute();
    }
}
