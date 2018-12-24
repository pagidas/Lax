package model;

public class Admin {

    private String username, password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static void createUser(int id, String fullname, String username, String password, String userRole) {
        User.createUser(id, fullname, username, password, userRole);
    }

    //public static void deleteUser()
}
    