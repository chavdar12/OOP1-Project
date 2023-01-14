package tu.varna.menu.subMenus;

import tu.varna.menu.Menu;
import tu.varna.util.FileUtil;

import java.util.List;
import java.util.Scanner;

public class OpenSubMenu extends Menu {

    private Scanner scanner;

    public OpenSubMenu() {
        super("Open Menu", List.of("Open"));
        this.scanner = new Scanner(System.in);
    }

    public void handleUserChoice() {
        int choice = getUserChoice();
        switch (choice) {
            case 1:
                System.out.println("Enter file path:");
                String filePath = scanner.nextLine();
                System.out.println("Opening file " + filePath + "...");
                FileUtil.loadTable(filePath);

                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
}
