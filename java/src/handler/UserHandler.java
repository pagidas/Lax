package handler;

import dao.UserDao;
import model.User;
import sha.SHA256;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserHandler {

    private static final String FULL_NAME_REGGEX = "^([A-Z][a-z]+ ?){2,}$";
    private static final String[] roles = {"Manager", "Designer", "Developer"};
    private static Scanner input;
    private UserHandler() {}

    public static void createUser() {
        // Creates a User object and inserts into database
        UserDao.insertUser(User.createUser(setFullName(), setUsername(), setPassword(), setUserRole()));
    }

    public static void deleteUser() {}

    private static String setFullName() {
        String fullName = null;
        input = new Scanner(System.in);

        do {
            System.out.println("Full Name: ");
            fullName = input.nextLine();
            } while(!isFullNameValid(fullName));

        return fullName;
    }

    private static String setUsername() {
        String username = null;
        input = new Scanner(System.in);

        System.out.println("Username: ");
        if(input.hasNextLine()) {
            username = input.nextLine();
            System.out.println("OK!");
            return username;
        }

        return null;
    }

    private static String setPassword() {
        String password = null;
        input = new Scanner(System.in);

        System.out.println("Password: ");
        try {
            password = SHA256.getSHA256HexToString(input.nextLine());
            System.out.println("OK!");
            return password;
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private static String setUserRole() {
        int option;
        input = new Scanner(System.in);
        System.out.println("Pick a User Role:");
        for(int i=0; i<roles.length; i++) {
            System.out.println(i+". "+roles[i]);
        }

        option = input.nextInt();
        if(option < 0 || option > roles.length) {
            System.out.println("Option does not exist!");
            return null;
        }
        else
            return roles[option];
    }

    private static boolean isFullNameValid(String fullName) {
        if(Pattern.matches(FULL_NAME_REGGEX, fullName)) {
            System.out.println("OK!");
            return true;
        }

        System.out.println("Full Name must be in the form of: 'Name Surname'");
        return false;
    }

    private static boolean isUsernameUnique() { return false; }
}
