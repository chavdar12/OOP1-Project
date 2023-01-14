package tu.varna.menu.subMenus;

import tu.varna.menu.Menu;

import java.util.List;

public class CloseSubMenu extends Menu {
    public CloseSubMenu() {
        super("Close Menu", List.of("Close"));
    }

    public void handleUserChoice() {
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                System.out.println("Closing the application...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
