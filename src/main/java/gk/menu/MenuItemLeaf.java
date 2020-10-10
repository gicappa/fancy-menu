package gk.menu;

import java.util.Collections;
import java.util.List;

public class MenuItemLeaf implements MenuItem {
    private final String name;

    public MenuItemLeaf(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public List<MenuItem> getItems() {
        return Collections.emptyList();
    }
}
