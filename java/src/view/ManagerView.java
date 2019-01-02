package view;

import menu.Menu;
import menu.MenuItem;
import state.Session;

public class ManagerView {

    private static Menu mainmenu;
    private static FrontController controller;

    //default constructor so controller to create the menu
    ManagerView() {}

    //private parameterized constructor which takes the constructed Menu and MenuItem
    ManagerView(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    /*
     *  This Method which creates a basic Menu with two MenuItem instances,
     *  calls the private constructor and passes the final menu.
     *  Returns the ManagerView itself.
     */
    ManagerView createManagerMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** Developer's basic Menu ***");
        mainmenu.addItem(new MenuItem("View All Issues", this, "performViewAllIssues"));
        mainmenu.addItem(new MenuItem("View all issues by ID", this, "performViewAllIssuesByID"));
        mainmenu.addItem(new MenuItem("View all Users", this, "performViewAllUsers"));
        mainmenu.addItem(new MenuItem("Logout", this, "performLogout"));

        ManagerView managerView = new ManagerView(mainmenu);

        return managerView;
    }

    /*
     *  This Method displays the Manager's mainmenu, running the execute() in Menu class.
     *  Returns <T> whatever the 'target' methods return.
     */
    <T> T displayMenu() {
        return mainmenu.execute();
    }

    /*
     *  Methods invoked by the Menu, depending on user's action.
     *  Read Menu.execute() which calls an invoke() on the MenuItem.
     */
    public void performViewAllIssues() { getRequest("VIEW_ALL_ISSUES"); }

    public void performViewAllIssuesByID() { getRequest("VIEW_ALL_ISSUES_BY_ID"); }

    public void performLogout() {
        getRequest("LOGOUT");
    }

    public void performViewAllUsers() { getRequest("VIEW_ALL_USERS"); }

    private void getRequest(String request) {
        controller = new FrontController();

        controller.dispatchRequest(request);
    }
}
