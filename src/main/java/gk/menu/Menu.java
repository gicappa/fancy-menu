package gk.menu;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Menu {

    private final List<MenuItem> names = new ArrayList<>();

    public void addItem(MenuItem name) {
        this.names.add(name);
    }

    @Override
    public String toString() {
        return names.stream()
                .map(this::printMenuItem)
                .collect(joining("\n"));
    }

    private String printMenuItem(MenuItem item) {
            return item.toString() + printChildren(item);
    }

    private String printChildren(MenuItem folder) {
        return folder.getItems().isEmpty() ? "" : "\n" + traverse(folder);
    }

    private String traverse(MenuItem folder) {
        return folder.getItems().stream().map(this::printMenuItemSecondLevel)
                .collect(joining("\n"));
    }

    private String printMenuItemSecondLevel(MenuItem item) {
        if (item instanceof MenuItemLeaf) {
            return " - " + item.toString();
        }
        return "";
    }

}
