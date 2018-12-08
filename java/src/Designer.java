public class Designer extends Programmer {

    //parameterized constructor
    Designer(String aName, String aUsername, String aPassword) {
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
