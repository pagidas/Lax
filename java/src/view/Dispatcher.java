package view;

import handler.UserHandler;
import login.Login;
import model.User;

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

    private static final String[] roles = {"Manager", "Designer", "Developer"};

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

    void dispatch(User aUser, String request) {

        if(aUser.getUserRole().equalsIgnoreCase(roles[0])) {
            if(request.equalsIgnoreCase("MANAGER")) {
                System.out.println("MANAGER MENU!");
                // managerView.displayMenu()
            }
            // other requests (what manager does)
        }

        if(aUser.getUserRole().equalsIgnoreCase(roles[1])) {
            if(request.equalsIgnoreCase("DESIGNER")) {
                System.out.println("DESIGNER MENU!");
                // designerView.displayMenu()
            }
            // other requests (what designer does)
        }

        if(aUser.getUserRole().equalsIgnoreCase(roles[2])) {
            if(request.equalsIgnoreCase("DEVELOPER")) {
                System.out.println("DEVELOPER MENU!");
                // developerView.displayMenu()
            }
            // other requests (what developer does)
        }
    }

    void dispatch(String request) {

        // View requests
        if(request.equalsIgnoreCase("ADMIN")) {
            adminView.displayMenu();
        }

        // Handler requests
        if(request.equalsIgnoreCase("CREATE_USER")) {
            UserHandler.createUser();
            adminView.displayMenu();
        }

        if(request.equalsIgnoreCase("DELETE_USER")) {
            //delete user
            //adminView.displayMenu();
        }

        if(request.equalsIgnoreCase("LOGOUT")) {
            System.out.println("Logging out...\n");
            Login.displayLogin();
            Login.login();
        }
    }
}
