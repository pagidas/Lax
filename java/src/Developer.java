public class Developer extends Programmer {

    //parameterized constructor
    Developer(String aName, String aUsername, String aPassword) {
        super(aName, aUsername, aPassword);
    }

    //getters
    @Override
    String getName() {
        return name;
    }

    @Override
    String getUsername() {
        return username;
    }

    @Override
    String getPassword() {
        return password;
    }
}
