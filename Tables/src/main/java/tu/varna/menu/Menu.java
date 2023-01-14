package tu.varna.menu;

import java.util.List;
import java.util.Scanner;

public class Menu implements IMenu {
    private String title;
    private List<String> options;
    private Scanner scanner;

    public Menu(String title, List<String> options) {
        this.title = title;
        this.options = options;
        this.scanner = new Scanner(System.in);
    }

    public void display() {
        System.out.println(title);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public void handleUserChoice() {
    }
}
