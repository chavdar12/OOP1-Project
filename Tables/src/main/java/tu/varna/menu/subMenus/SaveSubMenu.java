package tu.varna.menu.subMenus;

import tu.varna.menu.Menu;

import java.util.List;

public class SaveSubMenu extends Menu {
    public SaveSubMenu() {
        super("Save Menu", List.of("Save"));
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
