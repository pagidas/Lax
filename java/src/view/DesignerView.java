package view;

import menu.Menu;
import menu.MenuItem;

public class DesignerView {

    private static Menu mainmenu;
    private static FrontController controller;

    //default constructor so controller to create the menu
    DesignerView() {}

    //private parameterized constructor which takes the constructed Menu and MenuItem
    DesignerView(Menu mainmenu) {
        this.mainmenu = mainmenu;
    }

    /*
     *  This Method which creates a basic Menu with two MenuItem instances,
     *  calls the private constructor and passes the final menu.
     *  Returns the DesignerView itself.
     */
    DesignerView createDesignerMenu() {
        Menu mainmenu = new Menu();
        mainmenu.setTitle("*** Designers's basic Menu ***");
        mainmenu.addItem(new MenuItem("View All Issues", mainmenu, "performViewAllIssues"));
        mainmenu.addItem(new MenuItem("Post an Issue", mainmenu, "performPostAnIssue"));
        mainmenu.addItem(new MenuItem("Edit an Issue", mainmenu, "performEditAnIssue"));
        mainmenu.addItem(new MenuItem("Logout", mainmenu, "performLogout"));

        DesignerView designerMenu = new DesignerView(mainmenu);

        return designerMenu;
    }

    /*
     *  This Method displays the Designer's mainmenu, running the execute() in Menu class.
     *  Returns <T> whatever the 'target' methods return.
     */
    <T> T displayMenu() {
        return mainmenu.execute();
    }

    /*
     *  Methods invoked by the Menu, depending on user's action.
     *  Read Menu.execute() which calls an invoke() on the MenuItem.
     */
    public void performViewAllIssues() { getRequest("VIEW_ALL_USSES"); }

    public void performPostAnIssue() { getRequest("POST_AN_ISSUE"); }

    public void performEditAnissue() { getRequest("EDIT_AN_ISSUE"); }

    public void performLogout() {
        getRequest("LOGOUT");
    }

    private void getRequest(String request) {
        controller = new FrontController();

        controller.dispatchRequest(request);
    }
}
