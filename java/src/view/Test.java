package view;

import dao.UserDao;
import model.Admin;
import model.User;
import sha.SHA256;
import view.AdminView;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

//        //view.Test fields
//        int id = 3;
//        int deletedId = 2;
//
//
//        User theUser = UserDao.getUser(id);
//        System.out.println("The user with id='"+id+"' is "+theUser.getFullname()+"\n");
//
//        System.out.println("Changes the user's full name to...");
//        theUser.setFullname("Pantelis Altas");
//        System.out.println(theUser.getFullname()+"\n");
//
//        Set<User> users =  UserDao.getAllUsers();
//        System.out.println("All the users in DB are...");
//        for(User u : users) {
//            System.out.println(u);
//        }
//
//        System.out.println("\nUpdating the previous change into the DB...\n");
//        UserDao.updateUser(theUser);
//
//        System.out.println("Printing again the all users in DB...");
//        users =  UserDao.getAllUsers();
//        System.out.println("All the users in DB are...");
//        for(User u : users) {
//            System.out.println(u);
//        }
//        System.out.println();
//
//        Scanner in = new Scanner(System.in);
//        System.out.print("Insert user? ");
//        byte answer = Byte.parseByte(in.nextLine());
//
//        if(answer == (byte)1) {
//            System.out.println("Full Name: ");
//            String fullName = in.nextLine();
//
//            System.out.println("Username: ");
//            String username = in.nextLine();
//
//            System.out.println("Password: ");
//            String password = in.nextLine();
//
//            System.out.println("Role: ");
//            String role = in.nextLine();
//
//            UserDao.insertUser(Admin.createUser(fullName, username, password, role));
//        }
//
//        System.out.println("Printing the final Database...");
//        for(User u : users) {
//            System.out.println(u);
//        }
//
//        System.out.println("Deleting a user with id="+deletedId+"\n");
//        UserDao.deleteUser(deletedId);
//
//        System.out.println("Getting a User by username and password...");
//        System.out.print("username: ");
//        String uname = in.nextLine();
//        System.out.print("password: ");
//        String pwd = in.nextLine();
//        User authenticUser = UserDao.getUserByUsernameAndPassword(uname, pwd);
//        System.out.println(authenticUser);

//        AdminView a = new AdminView().createTheMenu();
//        System.out.println((String)a.displayMenu());

        try {
            String pwd = SHA256.getSHA256Hex("pagidas");
            System.out.println(pwd);
            String pwd2 = SHA256.getSHA256Hex("pagidat");
            System.out.println(pwd2);
            if(pwd.equalsIgnoreCase(pwd2)) {
                System.out.println("SHA256 works!");
            }
            else {
                System.out.println("Not working!");
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

    }
}
