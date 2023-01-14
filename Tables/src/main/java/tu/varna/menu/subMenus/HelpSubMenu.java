package tu.varna.menu.subMenus;

import tu.varna.menu.Menu;
import tu.varna.util.Constants;

import java.util.List;

public class HelpSubMenu extends Menu {
    public HelpSubMenu() {
        super("Help Menu", List.of("Help"));
    }

    public void handleUserChoice() {
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                System.out.println(Constants.HELP_MENU);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
