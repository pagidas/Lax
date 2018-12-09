public class Member {

    int id;
    private String fullname, username, password, userRole;
    public static final String roles[] = {"Admin", "Manager", "Designer", "Developer"};

    public Member(String fullname, String username, String password, String userRole) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
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

    public String getUserRole() {
        return userRole;
    }

    public static String[] getRoles() {
        return roles;
    }

    //setters?
}
