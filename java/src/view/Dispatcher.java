package view;

import menu.AdminMenu;

public class Dispatcher {

    private AdminMenu adminView;
    //designerMenu
    //managerMenu
    //developerMenu

    public void dispatch(String request) {
        if(request.equalsIgnoreCase("ADMIN")) {
            adminView.displayMenu();
        }
    }

}
