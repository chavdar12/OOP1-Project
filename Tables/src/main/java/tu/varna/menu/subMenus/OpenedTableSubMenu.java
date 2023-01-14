package tu.varna.menu.subMenus;

import tu.varna.menu.Menu;
import tu.varna.util.FileUtil;

import java.util.List;

public class OpenedTableSubMenu extends Menu {

    private FileUtil fileUtil;

    public OpenedTableSubMenu(FileUtil fileUtil) {
        super("Opened Table Menu", List.of("Save", "Save As", "Close"));
        this.fileUtil = fileUtil;
    }
}
