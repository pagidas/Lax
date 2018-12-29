package view;

public class Dispatcher {

    private AdminView adminView;
    private DesignerView designerView;
    private DeveloperView developerView;
    private ManagerView managerView;

    public Dispatcher() {
        //adminView = AdminView.createTheMenu();
        //designerView
        //managerView
        //developerView
    }
    //designerMenu
    //managerMenu
    //developerMenu

    public void dispatch(String request) {

        //Views
        if(request.equalsIgnoreCase("ADMIN")) {
            adminView.displayMenu();
        }
        if(request.equalsIgnoreCase("DESIGNER")) {
            //displayMenu()
        }
        if(request.equalsIgnoreCase("DEVELOPER")) {
            //displayMenu()
        }
        if(request.equalsIgnoreCase("MANAGER")) {
            //displayMenu()
        }

        //Other requests

    }
}
