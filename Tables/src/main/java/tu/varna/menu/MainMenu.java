package tu.varna.menu;

import java.util.Arrays;
import java.util.List;

public class MainMenu extends Menu {
    private List<IMenu> subMenus;

    public MainMenu(List<IMenu> subMenus) {
        super("Main Menu", Arrays.asList("Open", "Close", "Save", "Save as", "Help", "Exit"));
        this.subMenus = subMenus;
    }

    public void handleUserChoice() {
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                subMenus.get(0).display();
                subMenus.get(0).handleUserChoice();
                break;
            case 2:
                subMenus.get(1).display();
                subMenus.get(1).handleUserChoice();
                break;
            case 3:
                subMenus.get(2).display();
                subMenus.get(2).handleUserChoice();
                break;
            case 4:
                subMenus.get(3).display();
                subMenus.get(3).handleUserChoice();
                break;
            case 5:
                subMenus.get(4).display();
                subMenus.get(4).handleUserChoice();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
