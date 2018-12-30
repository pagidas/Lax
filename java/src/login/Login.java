package login;

import dao.UserDao;
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
        String answer;
        input = new Scanner(System.in);

        System.out.print("Do you want to Login [Y/N]: ");
        answer = input.next("^[Y/N]|^[y/n]");

        if(answer.equalsIgnoreCase("Y")) {
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
                    getRequest("");
                }
                else if(UserDao.getUserByUsernameAndPassword(username, password) != null) {
                    System.out.println("Valid credentials!");

                    User aUser = UserDao.getUserByUsernameAndPassword(username, password);
                    getRequest(aUser, aUser.getUserRole());
                    break;
                }
                else
                    validLogin = false;

            } while(!validLogin);
        }
        else {
            System.out.println("OK, Bye!");
        }
    }

    private static void getRequest(User aUser, String request) {
        controller = new FrontController();

        controller.dispatchRequest(aUser, request);
    }

    private static void getRequest(String request) {
        controller = new FrontController();

        controller.dispatchRequest(request);
    }
}
