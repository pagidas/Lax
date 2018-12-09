public class User {

    int id;
    private String fullname, username, password, userRole;
    public static final String roles[] = {"Manager", "Designer", "Developer"};

    /*
     *  Parameterized constructor to create a User, calling
     *  another method from Database class which executes the
     *  query with the parameters given.
     */
    public User(Database aDB, String fullname, String username, String password, String userRole) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.id = aDB.createMember(fullname, username, password, userRole);
    }

    //getters
    public String getFullname() {
        return fullname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMemberRole() {
        return userRole;
    }

    public static String[] getRoles() {
        return roles;
    }

    //setters?
}
