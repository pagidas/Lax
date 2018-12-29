package menu;

public class ManagerMenu {

    private static Menu mainmenu = null;

    private ManagerMenu(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    public static void createManagerMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** Manager's basic Menu ***");
        mainmenu.addItem(new MenuItem("View All Issues", mainmenu, "viewAllIssues"));
        mainmenu.addItem(new MenuItem("View Issues by User", mainmenu, "viewIssuesByUserName"));
        mainmenu.addItem(new MenuItem("Logout", mainmenu, "logout"));

        ManagerMenu managerMenu = new ManagerMenu(mainmenu);
    }

    public static void displayManagerMenu() {
        mainmenu.execute();
    }
}
