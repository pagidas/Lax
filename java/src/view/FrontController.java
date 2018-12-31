package view;

import dao.UserDao;
import files.myFile;
import handler.UserHandler;
import model.User;

public class FrontController {

    // Declaring a dispatcher in FrontController
    private final Dispatcher dispatcher = Dispatcher.createDispatcher();

    /*
     *  Checks if given username and password
     *  are the same credentials with those
     *  in the .xml file.
     */
    public boolean isAdmin(String username, String password) {
        if((username.equalsIgnoreCase(myFile.readXMLAdminUname()) &&
            password.equalsIgnoreCase(myFile.readXMLAdminPwd()))) {

            System.out.println("This is Admin!");
            return true;
        }

        return false;
    }

    public User isAuthenticUser(String username, String password) {
        return UserHandler.isUser(username, password);
    }

    public void trackRequest(String request) {
        System.out.println("Page requested: "+request);
    }

    public void dispatchRequest(String request) {
        trackRequest(request);

        dispatcher.dispatch(request);
    }
}
