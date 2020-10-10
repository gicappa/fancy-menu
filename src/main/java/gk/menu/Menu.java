package gk.menu;

import static java.util.stream.Collectors.joining;

public class Menu {

    private final RootMenuItem root = new RootMenuItem();

    public void addItem(MenuItem item) {
        root.addItem(item);
    }

    @Override
    public String toString() {
        return root.traverse(this::printMenuItem);
    }

    private String printChildren(MenuItem item) {
        return item.getItems().isEmpty() ? item.traverse(this::printMenuItemSecondLevel) : "\n" + item.traverse(this::printMenuItemSecondLevel);
    }

    private String printMenuItem(MenuItem item) {
        return item.toString() + printChildren(item);
    }

    private String printMenuItemSecondLevel(MenuItem item) {
        if (item instanceof MenuItemLeaf) {
            return " - " + item.toString();
        }
        return "";
    }

}
