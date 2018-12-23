package dao;

import model.User;

public class UserDao {

    public User getUser(int id) {
        //open connection

        //execute sql query

        //retrieve data from ResultSet

        return User.createUser(id, fullname, username, password, userRole);
    }
    public boolean insertUser() {}
    public boolean updateUser() {}
    public boolean deleteUser() {}

}
