package gk.menu;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;

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

    @Override
    public String traverse(Function<MenuItem, String> f) {
        return "";
    }

}
