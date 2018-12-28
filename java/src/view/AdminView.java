package view;

import menu.Menu;
import menu.MenuItem;

public class AdminView {

    private static Menu mainmenu;
    private static FrontController controller;

    private AdminView() {}

    private AdminView(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    /*
     *  This Method which creates a basic Menu with two MenuItem instances,
     *  calls the private constructor and passes the final menu.
     *  Returns the AdminView itself.
     */
    public static AdminView createTheMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** My Main Menu ***");
        mainmenu.addItem(new MenuItem("Create a user", mainmenu, "createUser"));
        mainmenu.addItem(new MenuItem("Delete a user", mainmenu, "deleteUser"));
        mainmenu.addItem(new MenuItem("Logout", mainmenu, "logout"));

        AdminView adminMenu = new AdminView(mainmenu);

        return adminMenu;
    }

    /*
     * This Method displays the Admin's mainmenu, running the execute() in Menu class
     */
    public void displayMenu() {
        mainmenu.execute();
    }

    public void createUser() {
        getRequest("CREATE_USER");
    }

    public void deleteUser() {
        getRequest("DELETE_USER");
    }

    public void logout() {
        getRequest("LOGOUT");
    }

    public void getRequest(String request) {

    }


}
