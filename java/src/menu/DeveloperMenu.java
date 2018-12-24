package menu;

public class DeveloperMenu {

    private static Menu mainmenu = null;

    private DeveloperMenu(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    public static void createDeveloperMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** Developer's basic Menu ***");
        mainmenu.addItem(new MenuItem("View All Issues", mainmenu, "viewAllIssues"));
        mainmenu.addItem(new MenuItem("Post an Issue", mainmenu, "postAnIssue"));
        mainmenu.addItem(new MenuItem("Logout", mainmenu, "logout"));

        DeveloperMenu developerMenu = new DeveloperMenu(mainmenu);
    }

    public static void displayDeveloperMenu() {
        mainmenu.execute();
    }
}
