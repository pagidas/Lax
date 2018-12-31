package model;

public class User {

    private int id;
    private String fullname, username, password, userRole;
    public static final String roles[] = {"Manager", "Designer", "Developer"};


    /*
     *  Parameterized constructor when fetching User's data from a Database
     */
    private User(int id, String fullname, String username, String password, String userRole) {
        setFullname(fullname);
        setUsername(username);
        setPassword(password);
        setUserRole(userRole);
        setId(id);
    }
    /*
     *  Parameterized constructor when creating a new User and the ID is updated by the Database
     */
    private User(String fullname, String username, String password, String userRole) {
        setFullname(fullname);
        setUsername(username);
        setPassword(password);
        setUserRole(userRole);
    }

    public User(){}

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

    public int getId() {
        return id;
    }

    public static String[] getRoles() {
        return roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void setFullname(String fullname) {
        this.fullname = fullname;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    private void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    /*
     *  This method is needed to create an object in the back-end,
     *  and the ID is updated when it is inserted into the database.
     */
    public static User createUser(String fullname, String username, String password, String userRole) {
        User u = new User(fullname, username, password, userRole);

        return u;
    }

    /*
     *  This method is needed to create an object when fetching
     *  user's info from database, thus the ID.
     */
    public static User createUser(int id, String fullname, String username, String password, String userRole) {
        User u = new User(id, fullname, username, password, userRole);

        return u;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
