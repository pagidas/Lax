package view;

import menu.Menu;
import menu.MenuItem;
import model.Admin;

import java.io.IOException;

public class AdminView {

    private static Menu mainmenu;
    private static FrontController controller;

    //default constructor in the Controller to create the menu
    AdminView() {}

    //private parameterized constructor which takes the constructed Menu and MenuItem
    private AdminView(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    /*
     *  This Method which creates a basic Menu with two MenuItem instances,
     *  calls the private constructor and passes the final menu.
     *  Returns the AdminView itself.
     */
    AdminView createTheMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** My Main Menu ***");
        mainmenu.addItem(new MenuItem("Create a user", this, "performCreateUser"));
        mainmenu.addItem(new MenuItem("Delete a user", this, "performDeleteUser"));
        mainmenu.addItem(new MenuItem("Logout", this, "performLogout"));

        AdminView adminView = new AdminView(mainmenu);

        return adminView;
    }

    /*
     *  Methods invoked by the Menu, depending on user's action.
     *  Read Menu.execute() which calls an invoke() on the MenuItem.
     */
    public String performCreateUser() {
        return "CREATE_USER";
    }

    public String performDeleteUser() {
        return "DELETE_USER";
    }

    public String performLogout() {
        return "LOGOUT";
    }

    /*
     *  This Method displays the Admin's mainmenu, running the execute() in Menu class.
     *  Returns <T> whatever the 'target' methods return.
     */
    <T> T displayMenu() {
        return mainmenu.execute();
    }

    private void getRequest(String request) {}
}
