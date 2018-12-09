public class Member {

    int id;
    private String fullname, username, password, memberRole;
    public static final String roles[] = {"Manager", "Designer", "Developer"};

    /*
     *  Parameterized constructor to create a Member, calling
     *  another method from Database class which executes the
     *  query with the parameters given.
     */
    public Member(Database aDB, String fullname, String username, String password, String memberRole) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.memberRole = memberRole;
        this.id = aDB.createMember(fullname, username, password, memberRole);
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
