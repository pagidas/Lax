package view;

import com.sun.org.apache.regexp.internal.RE;
import dao.UserDao;
import handler.IssueHandler;
import handler.UserHandler;
import login.Login;
import model.Issue;
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
        else if(request.equalsIgnoreCase("DESIGNER")) {
            designerView.displayMenu();
        }
        else if(request.equalsIgnoreCase("DEVELOPER")) {
            developerView.displayMenu();
        }
        else if(request.equalsIgnoreCase("MANAGER")) {
            managerView.displayMenu();
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

        if(request.equalsIgnoreCase("POST_AN_ISSUE")) {

            // getting the user_id from session
            int userId = Session.getInstance().getSessionId();

            IssueHandler.postIssue(userId);

            // getting back the original view
            if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DESIGNER"))
                designerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DEVELOPER"))
                developerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("MANAGER"))
                managerView.displayMenu();
        }
        if(request.equalsIgnoreCase("VIEW_ALL_ISSUES")) {

            // getting the user_id from session
            int userId = Session.getInstance().getSessionId();

            IssueHandler.showAllIssues();

            // getting back the original view
            if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DESIGNER"))
                designerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DEVELOPER"))
                developerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("MANAGER"))
                managerView.displayMenu();
        }
        if(request.equalsIgnoreCase("EDIT_AN_ISSUE")) {

            // getting the user_id from session
            int userId = Session.getInstance().getSessionId();

            IssueHandler.editAnIssue();

            // getting back the original view
            if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DESIGNER"))
                designerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DEVELOPER"))
                developerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("MANAGER"))
                managerView.displayMenu();
        }
        if(request.equalsIgnoreCase("DELETE_AN_ISSUE")) {

            // getting the user_id from session
            int userId = Session.getInstance().getSessionId();

            IssueHandler.deleteIssue();

            // getting back the original view
            if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DESIGNER"))
                designerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DEVELOPER"))
                developerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("MANAGER"))
                managerView.displayMenu();
        }
        if(request.equalsIgnoreCase("VIEW_ALL_ISSUES_BY_ID")) {

            // getting the user_id from session
            int userId = Session.getInstance().getSessionId();

            IssueHandler.viewIssuesByUser();

            // getting back the original view
            if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DESIGNER"))
                designerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DEVELOPER"))
                developerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("MANAGER"))
                managerView.displayMenu();
        }
        if(request.equalsIgnoreCase("VIEW_ALL_USERS")) {

            // getting the user_id from session
            int userId = Session.getInstance().getSessionId();

            IssueHandler.viewAllUsers();

            // getting back the original view
            if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DESIGNER"))
                designerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("DEVELOPER"))
                developerView.displayMenu();
            else if(UserDao.getUser(userId).getUserRole().equalsIgnoreCase("MANAGER"))
                managerView.displayMenu();
        }

        // Logout request
        if(request.equalsIgnoreCase("LOGOUT")) {
            System.out.println("Logging out...\n");
            Login.displayLogin();
        }
    }
}
