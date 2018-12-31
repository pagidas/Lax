package login;

import model.User;
import state.Session;
import view.FrontController;

import java.util.Scanner;

public class Login {

    private static StringBuilder sb;
    private static Scanner input;
    private static FrontController controller;

    private Login() {}

    public static void displayLogin() {
        String answer;
        input = new Scanner(System.in);

        sb = new StringBuilder("*** Login Form ***\n")
                .append("username:\n")
                .append("password:\n")
                .append("Do you want to Login [Y/N]: ");

        System.out.print(sb.toString());

        answer = input.next("^[Y/N]|^[y/n]");
        if(answer.equalsIgnoreCase("Y")) {
            login();
        }
        else {
            System.out.println("OK, Bye!");
            System.exit(0);
        }
    }

    public static void login() {
        boolean validLogin = false;
        input = new Scanner(System.in);

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
                getRequest("ADMIN");
            }
            else if(controller.isAuthenticUser(username, password) != null) {
                System.out.println("Valid credentials!");

                User aUser = controller.isAuthenticUser(username, password);

                // Creating a unique session for that user
                Session session = Session.getInstance();
                session.setSessionId(aUser.getId());

                getRequest(session, aUser.getUserRole());
            }
            else
                validLogin = false;

        } while(!validLogin);
    }

    private static void getRequest(String request) {
        controller = new FrontController();

        controller.dispatchRequest(request);
    }

    private static void getRequest(Session session, String request) {
        controller = new FrontController();

        controller.dispatchRequest(session, request);
    }
}
