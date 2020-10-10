package gk.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.joining;

public class MenuItemFolder implements MenuItem {
    private final String folder;
    private final List<MenuItem> children = new ArrayList<>();

    public MenuItemFolder(String folder) {
        this.folder = folder;
    }

    @Override
    public String toString() {
        return " + " + folder;
    }

    public void addItem(MenuItemLeaf menuItemLeaf) {
        children.add(menuItemLeaf);
    }

    @Override
    public List<MenuItem> getItems() {
        return children;
    }

    public String traverse(Function<MenuItem, String> f) {
        return getItems().stream().map(f)
                .collect(joining("\n"));
    }
}
