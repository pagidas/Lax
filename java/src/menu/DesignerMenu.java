package menu;

public class DesignerMenu {

    private static Menu mainmenu = null;

    private DesignerMenu(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    public static void createDesignerMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** Designers's basic Menu ***");
        mainmenu.addItem(new MenuItem("View All Issues", mainmenu, "viewAllIssues"));
        mainmenu.addItem(new MenuItem("Post an Issue", mainmenu, "postAnIssue"));
        mainmenu.addItem(new MenuItem("Logout", mainmenu, "logout"));

        DesignerMenu designerMenu = new DesignerMenu(mainmenu);
    }

    public static void displayDesignerMenu() {
        mainmenu.execute();
    }
}
