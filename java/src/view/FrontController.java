package view;

import java.awt.*;

public class FrontController {

    private Dispatcher dispatcher;

    private FrontController() {}

    private boolean isAuthenticUser() {
        System.out.println("User is authenticated successfully!");
        return true;
    }

    private void trackRequest(String request) {
        System.out.println("Page requested: "+request);
    }

    private void dispatchRequest(String request) {
        trackRequest(request);

        if(isAuthenticUser()) {
            dispatcher.dispatch(request);
        }

    }
}
