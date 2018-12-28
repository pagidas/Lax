package view;

import dao.UserDao;
import model.User;

public class FrontController {

    private Dispatcher dispatcher;

    boolean isAuthenticUser(User aUser) {
        if(aUser != null) {
            System.out.println("User is authenticated successfully!");
            return true;
        }

        return false;
    }

    void trackRequest(String request) {
        System.out.println("Page requested: "+request);
    }

    void dispatchRequest(String request, User aUser) {
        trackRequest(request);

        if(isAuthenticUser(aUser)) {
            dispatcher.dispatch(request);
        }

    }
}
