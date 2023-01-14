package tu.varna.menu.subMenus;

import tu.varna.menu.Menu;

import java.util.List;

public class SaveAsSubMenu extends Menu {
    public SaveAsSubMenu() {
        super("Save As Menu", List.of("Save As"));
    }

    public void handleUserChoice() {
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                System.out.println("Saving...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
