package model;

public class Admin {

    private String username, password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static User createUser(String fullname, String username, String password, String userRole) {
        User aUser =  User.createUser(fullname, username, password, userRole);

        return aUser;
    }

    //public static void deleteUser()
}
    