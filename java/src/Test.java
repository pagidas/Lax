import dao.UserDao;
import model.User;

import java.util.Iterator;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        int id = 2;
        User aUser = UserDao.getUser(id);
        System.out.println("The user with id='"+id+"' is "+aUser.getFullname()+"\n");

        Set<User> users =  UserDao.getAllUsers();
        System.out.println("All the users are...");
        for(User u : users) {
            System.out.println(u);
        }
    }
}
