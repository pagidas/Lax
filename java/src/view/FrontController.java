package view;

import dao.UserDao;
import files.myFile;
import model.User;

public class FrontController {

    // Declaring a dispatcher in FrontController
    private final Dispatcher dispatcher = Dispatcher.createDispatcher();

    public User authenticUser(String username, String password) {
        return UserDao.getUserByUsernameAndPassword(username, password);
    }

    public String authorizedUser(User authenticUser) {
        return authenticUser.getUserRole();
    }

    /*
     *  Reads from an XML file if given credentials are Admin's
     */
    public boolean isAdmin(String username, String password) {
        if((username.equalsIgnoreCase(myFile.readXMLAdminUname())) &&
            password.equalsIgnoreCase(myFile.readXMLAdminPwd())) {

            System.out.println("User is Admin!");
            return true;
        }

        return false;
    }

    public void trackRequest(String request) {
        System.out.println("Page requested: "+request);
    }

    public void dispatchRequest(String request) {
        trackRequest(request);

        dispatcher.dispatch(request);
    }
}
