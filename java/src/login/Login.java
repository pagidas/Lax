package login;

import model.User;
import view.FrontController;

import java.util.Scanner;

public class Login {

    private static StringBuilder sb;
    private static Scanner input;
    private static FrontController controller;

    private Login() {}

    public static void displayLogin() {
        sb = new StringBuilder("*** Login Form ***\n")
                .append("username:\n")
                .append("password:");

        System.out.println(sb.toString());
    }

    public static void login() {
        boolean validLogin = false;
        do {
            controller = new FrontController();
            input = new Scanner(System.in);
            String username, password;

            System.out.println("Give me your login credentials (username, password): ");
            System.out.print("> ");
            username = input.next();

            System.out.print("> ");
            password = input.next();

            if(controller.isAdmin(username, password)) {
                sendRequest("ADMIN");
                break;
            }
            else if(controller.authenticUser(username, password) != null) {
                System.out.println("Valid credentials!");
                sendRequest(controller.authorizedUser(controller.authenticUser(username, password)));
                break;
            }
            else
                validLogin = false;

        } while(!validLogin);

    }

    private static void sendRequest(String request) {
        getRequest(request);
    }

    private static void getRequest(String request) {
        controller = new FrontController();

        controller.dispatchRequest(request);
    }
}
