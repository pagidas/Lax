package handler;

import dao.UserDao;
import model.User;
import sha.SHA256;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class UserHandler {

    private static final String FULL_NAME_REGGEX = "^([A-Z][a-z]+ ?){2,}$";
    private static final String[] roles = {"Manager", "Designer", "Developer"};
    private static Scanner input;
    private UserHandler() {}

    public static void createUser() {
        // Creates a User object and inserts into database
        if(UserDao.insertUser(User.createUser(setFullName(), setUsername(), setPassword(), setUserRole())))
            System.out.println("USER HAS BEEN SUCCESSFULLY INSERTED INTO THE DATABASE");

    }

    public static void deleteUser() {
        input = new Scanner(System.in);

        System.out.print("Delete by ID > ");
        if(UserDao.deleteUser(input.nextInt()))
            System.out.println("USER HAS BEEN SUCCESSFULLY DELETED");
        else
            System.out.println("Wrong ID!");

    }

    public static void showAllUsers() {
        Set<User> users = UserDao.getAllUsers();

        System.out.println("\nID\t\tFull Name\t\t\t\tRole");
        System.out.println("-----------------------------------------");
        for(User aUser : users) {
            System.out.println(aUser.getId()+"\t\t"+aUser.getFullname()+"\t\t\t"+aUser.getUserRole());
        }
    }

    public static User isUser(String username, String password) {
        return UserDao.getUserByUsernameAndPassword(username, password);
    }

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
        String hexPwd = null;
        input = new Scanner(System.in);

        System.out.println("Password: ");
        try {
            // generating the given password to a hex representation, using SHA256
            hexPwd = SHA256.getSHA256HexToString(input.nextLine());
            System.out.println("OK!");
            return hexPwd;
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
}
