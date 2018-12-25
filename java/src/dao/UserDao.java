package dao;

import database.Database;
import database.MyDB;
import model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDao {

    public static User getUser(int id) {

        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM `lax_db`.`users` WHERE id="+id+";");

        ResultSet result = MyDB.connectAndExecute(String.valueOf(sqlQuery), (byte)0);

        try {
            if(result.next()) {
                User aUser = extractUserFromResultSet(result);
                return aUser;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static Set<User> getAllUsers() {
        Set<User> users = new HashSet();
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM `lax_db`.`users`;");

        ResultSet result = MyDB.connectAndExecute(String.valueOf(sqlQuery), (byte)0);

        try {
            while(result.next()) {
                User aUser = extractUserFromResultSet(result);

                users.add(aUser);
            }

            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }
//    public boolean insertUser() {}
//    public boolean updateUser() {}
//    public boolean deleteUser() {}

    public static User extractUserFromResultSet(ResultSet result) throws SQLException {

        return User.createUser(result.getInt("id"),
                result.getString("fullName"),
                result.getString("username"),
                result.getString("password"),
                result.getString("role"));
    }
}
