public class User {

    int id;
    private String fullname, username, password, memberRole;
    public static final String roles[] = {"Admin", "Manager", "Designer", "Developer"};

    public User(String fullname, String username, String password, String memberRole) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.memberRole = memberRole;
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
        return memberRole;
    }

    public static String[] getRoles() {
        return roles;
    }

    //setters?
}
