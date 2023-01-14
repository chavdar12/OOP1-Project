package tu.varna;

import tu.varna.menu.IMenu;
import tu.varna.menu.MainMenu;
import tu.varna.menu.subMenus.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<IMenu> subMenus = new ArrayList<>();
        subMenus.add(new OpenSubMenu());
        subMenus.add(new CloseSubMenu());
        subMenus.add(new SaveSubMenu());
        subMenus.add(new SaveAsSubMenu());
        subMenus.add(new HelpSubMenu());
        MainMenu mainMenu = new MainMenu(subMenus);
        while (true) {
            mainMenu.display();
            mainMenu.handleUserChoice();
        }
    }
}
