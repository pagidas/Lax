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

    public static boolean insertUser(User aUser) {
        StringBuilder sqlQuery = new StringBuilder("INSERT INTO `lax_db`.`users` (`fullName`,`username`,`password`,`role`) ")
                .append("VALUES ('"+aUser.getFullname()+"', '"+aUser.getUsername()+"', ")
                .append("'"+aUser.getPassword()+"', '"+aUser.getUserRole()+"');");

        int affectedRow = MyDB.connectAndExecute(String.valueOf(sqlQuery), (byte)1);

        if(affectedRow == 1) {
            return true;
        }

        return false;
    }

    public static boolean deleteUser(int id) {
        StringBuilder sqlQuery = new StringBuilder("DELETE FROM `lax_db`.`users` WHERE id="+id+";");

        int affectedRow = MyDB.connectAndExecute(String.valueOf(sqlQuery), (byte)1);

        if(affectedRow == 1) {
            return true;
        }

        return false;
    }

    public static boolean updateUser(User aUser) {
        StringBuilder sqlQuery = new StringBuilder("UPDATE `lax_db`.`users` SET fullName='"+aUser.getFullname()+"', ")
                .append("username='"+aUser.getUsername()+"', ")
                .append("password='"+aUser.getPassword()+"', ")
                .append("role='"+aUser.getUserRole()+"' ")
                .append("WHERE id="+aUser.getId()+";");

        int affectedRow = MyDB.connectAndExecute(String.valueOf(sqlQuery), (byte)1);

        if(affectedRow == 1) {
            return true;
        }

        return false;
    }

    /*
     *  This method fetches data from ResultSet and creates a User
     */
    public static User extractUserFromResultSet(ResultSet result) throws SQLException {

        return User.createUser(result.getInt("id"),
                result.getString("fullName"),
                result.getString("username"),
                result.getString("password"),
                result.getString("role"));
    }
}
