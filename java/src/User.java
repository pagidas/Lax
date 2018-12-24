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
        setId(0); //fix id, a createUser by a database which wil return the updated id
    }

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

    private void setId(int id) {
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
     *  --- Create for User ---
     *  This method wil be called by the Controller class
     *  and it's gonna call the constructor to create the object
     */
    public static User createUser(int id, String fullname, String username, String password, String userRole) {
        User u = new User(id, fullname, username, password, userRole);

        return u;
    }

    /*
     * --- Update for User ---
     * These methods wil be called by the Controller class.
     * id must be updated
     */
    public User updateUserFullname(int id, User u, String fullname) {
        u.setFullname(fullname);
        u.setId(id);

        return u;
    }

    public User updateUserUsername(int id, User u, String username) {
        u.setUsername(username);
        u.setId(id);

        return u;
    }

    public User updateUserPassword(int id, User u, String password) {
        u.setPassword(password);
        u.setId(id);

        return u;
    }

    public User updateUserRole(int id, User u, String userRole) {
        u.setUserRole(userRole);
        u.setId(id);

        return u;
    }
}
