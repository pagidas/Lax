package menu;

public class AdminMenu {

    private static Menu adminMenu = new Menu();
    private static MenuItem menuItem1 = new MenuItem("Create a user", adminMenu, "createUser");
    private static MenuItem menuItem2 = new MenuItem("Delete a user", adminMenu, "deleteUser");
    private static MenuItem menuItem3 = new MenuItem("Logout", adminMenu, "logout");

    /*
     * This Method displays the Admin's mainmenu, running the execute() off the Menu class
     */
    public static void displayMenu() {
        adminMenu.execute();
    }


}
