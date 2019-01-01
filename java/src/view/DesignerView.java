package view;

import menu.Menu;
import menu.MenuItem;
import state.Session;

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
        mainmenu.addItem(new MenuItem("View All Issues", this, "performViewAllIssues"));
        mainmenu.addItem(new MenuItem("Post an Issue", this, "performPostAnIssue"));
        mainmenu.addItem(new MenuItem("Edit an Issue", this, "performEditAnIssue"));
        mainmenu.addItem(new MenuItem("Logout", this, "performLogout"));

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

    public void performViewAllIssues() { getRequest("VIEW_ALL_ISSSES"); }

    public void performPostAnIssue() { getRequest("POST_AN_ISSUE"); }

    public void performEditAnissue() { getRequest("EDIT_AN_ISSUE"); }

    public void performLogout() { getRequest("LOGOUT"); }

    private void getRequest(String request) {
        controller = new FrontController();

        controller.dispatchRequest(request);
    }
}
