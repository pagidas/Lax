package view;

import dao.UserDao;
import handler.UserHandler;
import model.Admin;

/*
 *  This class has a method which delegates the given request
 *  to the appropriate Handler or View
 */
public class Dispatcher {

    //fields about the different Views
    private AdminView adminView;
    private DesignerView designerView;
    private DeveloperView developerView;
    private ManagerView managerView;

    //fields about the different Handlers

    //private default constructor
    private Dispatcher() {
        adminView = new AdminView().createTheMenu();
        //designerView
        //managerView
        //developerView
    }

    static Dispatcher createDispatcher() {
        Dispatcher d;

        return d = new Dispatcher();
    }

    void dispatch(String request) {

        //View requests
        if(request.equalsIgnoreCase("ADMIN")) {
            adminView.displayMenu();
        }
        if(request.equalsIgnoreCase("DESIGNER")) {
            //displayMenu()
            System.out.println("DESIGNER MAIN MENU");
        }
        if(request.equalsIgnoreCase("DEVELOPER")) {
            //displayMenu()
            System.out.println("DEVELOPER MAIN MENU");
        }
        if(request.equalsIgnoreCase("MANAGER")) {
            //displayMenu()
            System.out.println("MANAGER MAIN MENU");
        }

        //Handler requests
        if(request.equalsIgnoreCase("CREATE_USER")) {
            UserHandler.createUser();
        }

    }
}
