package menu;

public class AdminMenu {

    private static Menu mainmenu = null;

    private AdminMenu(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    /*
     *  This Method which creates a basic Menu with two MenuItem instances,
     *  calls the private constructor and passes the final menu.
     *  Returns the AdminMenu itself.
     */
    public static AdminMenu createTheMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** My Main Menu ***");
        mainmenu.addItem(new MenuItem("Create a user", mainmenu, "createUser"));
        mainmenu.addItem(new MenuItem("Delete a user", mainmenu, "deleteUser"));
        mainmenu.addItem(new MenuItem("Logout", mainmenu, "logout"));

        AdminMenu adminMenu = new AdminMenu(mainmenu);

        return adminMenu;
    }

    /*
     * This Method displays the Admin's mainmenu, running the execute() in Menu class
     */
    public void displayMenu() {
        mainmenu.execute();
    }


}
