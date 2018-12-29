package view;

import dao.UserDao;
import model.User;

public class FrontController {

    //declaring a dispatcher in FrontController
    private final Dispatcher dispatcher = Dispatcher.createDispatcher();

    boolean isAuthenticUser() {

        return true;
    }

    void trackRequest(String request) {
        System.out.println("Page requested: "+request);
    }

    void dispatchRequest(String request) {
        trackRequest(request);

        if(isAuthenticUser()) {
            dispatcher.dispatch(request);
        }

    }
}
