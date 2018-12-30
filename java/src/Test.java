import dao.UserDao;
import files.myFile;
import login.Login;
import model.Admin;
import model.User;
import sha.SHA256;
import view.AdminView;

import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {

//        AdminView adminView = new AdminView().createTheMenu();
//        adminView.displayMenu();

        Login.displayLogin();
        Login.login();
    }
}
