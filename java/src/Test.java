import dao.UserDao;
import model.User;

import java.util.Iterator;
import java.util.Set;

public class Test {

    public static void main(String[] args) {

        User aUser = UserDao.getUser(2);
        System.out.println(aUser.getFullname());

        Set<User> users =  UserDao.getAllUsers();
        for(User u : users) {
            System.out.println(aUser);
        }
    }
}
