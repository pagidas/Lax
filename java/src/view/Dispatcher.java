package view;

import handler.UserHandler;
import login.Login;
import menu.ConsoleUtils;
import model.User;
import state.Session;

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
        designerView = new DesignerView().createDesignerMenu();
        developerView = new DeveloperView().createDeveloperMenu();
        managerView = new ManagerView().createManagerMenu();
    }

    static Dispatcher createDispatcher() {
        Dispatcher d;

        return d = new Dispatcher();
    }

    /*
     *  This method delegates requests only for Admin.
     *  Admin is not a class, but a root username and a password,
     *  written in a .xml file.
     */
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
            UserHandler.deleteUser();
            adminView.displayMenu();
        }

        if(request.equalsIgnoreCase("SHOW_ALL_USERS")) {
            UserHandler.showAllUsers();
            adminView.displayMenu();
        }

        if(request.equalsIgnoreCase("UPDATE_USER")) {
            //UserHandler.showAllUsers();
            //adminView.displayMenu();
        }

        // Logout request
        if(request.equalsIgnoreCase("LOGOUT")) {
            System.out.println("Logging out...\n");
            Login.displayLogin();
        }
    }

    /*
     *  This method delegates requests for users (Manager, Developer, Designer),
     *  using only one session each time, if needed.
     */
    void dispatch(Session session, String request) {

        // View requests
        if(request.equalsIgnoreCase("DESIGNER")) {
            designerView.displayMenu();
        }
        else if(request.equalsIgnoreCase("DEVELOPER")) {
            developerView.displayMenu();
        }
        else if(request.equalsIgnoreCase("MANAGER")) {
            managerView.displayMenu();
        }

        // Handler requests

        // Logout request
        if(request.equalsIgnoreCase("LOGOUT")) {
            System.out.println("Logging out...\n");
            Login.displayLogin();
        }

    }
}
