import dao.UserDao;
import model.User;

public class Test {

    public static void main(String[] args) {

        User aUser = UserDao.getUser(2);
        System.out.println(aUser.getFullname());

    }

}
