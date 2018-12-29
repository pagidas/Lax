package view;

import dao.UserDao;
import handler.UserHandler;

public class Dispatcher {

    //fields about the different Views
    private AdminView adminView;
    private DesignerView designerView;
    private DeveloperView developerView;
    private ManagerView managerView;

    //fields about the different Handlers

    //private default constructor
    private Dispatcher() {
        //adminView = AdminView.createTheMenu();
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
        }
        if(request.equalsIgnoreCase("DEVELOPER")) {
            //displayMenu()
        }
        if(request.equalsIgnoreCase("MANAGER")) {
            //displayMenu()
        }

        //Handler requests
        if(request.equalsIgnoreCase("CREATE_USER")) {
            UserHandler.createUser();
        }
    }
}
