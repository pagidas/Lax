public abstract class Programmer {

    String name, username, password;

    //parameterized constructor
    Programmer(String aName, String aUsername, String aPassword) {
        name = aName;
        username = aUsername;
        password = aPassword;
    }

    //getters
    abstract String getName();
    abstract String getUsername();
    abstract String getPassword();

}
