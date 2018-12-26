package view;

import menu.AdminMenu;
import menu.DesignerMenu;
import menu.DeveloperMenu;
import menu.ManagerMenu;

public class Dispatcher {

    private AdminMenu adminView;
    private DesignerMenu designerView;
    private DeveloperMenu developerView;
    private ManagerMenu managerView;

    public Dispatcher() {
        adminView = AdminMenu.createTheMenu();
        //designerView
        //managerView
        //developerView
    }
    //designerMenu
    //managerMenu
    //developerMenu

    public void dispatch(String request) {
        if(request.equalsIgnoreCase("ADMIN")) {
            adminView.displayMenu();
        }
    }

}
