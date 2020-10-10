package gk.menu;

import java.util.ArrayList;
import java.util.List;

public class MenuItemFolder implements MenuItem {
    private final String folder;
    private final List<MenuItem> child = new ArrayList<>();

    public MenuItemFolder(String folder) {
        this.folder = folder;
    }

    @Override
    public String toString() {
        return " + " + folder;
    }

    public void addItem(MenuItemLeaf menuItemLeaf) {
        child.add(menuItemLeaf);
    }

    public List<MenuItem> getItems() {
        return child;
    }
}
