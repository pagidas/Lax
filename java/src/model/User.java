package model;

public class User {

    private int id;
    private String fullname, username, password, userRole;
    public static final String roles[] = {"Manager", "Designer", "Developer"};


    /*
     *  Parameterized constructor
     */
    private User(int id, String fullname, String username, String password, String userRole) {
        setFullname(fullname);
        setUsername(username);
        setPassword(password);
        setUserRole(userRole);
        setId(id);
    }

    //default constructor
    //public User(){}

    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserRole() {
        return userRole;
    }

    public static String[] getRoles() {
        return roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /*
     *  --- Create for User ---
     *  This method wil be called by the Controller class
     *  and it's gonna call the constructor to create the object
     */
    public static User createUser(int id, String fullname, String username, String password, String userRole) {
        User u = new User(id, fullname, username, password, userRole);

        return u;
    }
}
